package com.fort0.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.data.source.remote.ApiResponse
import com.fort0.moviecatalogue.data.source.remote.RemoteDataSource
import com.fort0.moviecatalogue.data.source.remote.response.MovieResponse
import com.fort0.moviecatalogue.data.source.remote.response.TvShowResponse
import com.fort0.moviecatalogue.room.LocalDataSource
import com.fort0.moviecatalogue.utils.AppExecutors
import com.fort0.moviecatalogue.utils.NetworkBoundResource
import com.fort0.moviecatalogue.utils.Resource

class FakeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : DataSource {

    override fun getMovieList(): LiveData<Resource<PagedList<Movies>>> {
        return object : NetworkBoundResource<PagedList<Movies>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<Movies>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<Movies>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<Movies>()
                for (response in data) {
                    val movie = Movies(
                        response.name,
                        response.viewerRating,
                        response.genre,
                        response.year,
                        response.description,
                        response.image,
                        response.id
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(movieId: String): LiveData<Movies> {
        val result = MutableLiveData<Movies>()

        remoteDataSource.getCallbackMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                var movie = Movies()
                for (response in movieResponse) {
                    if (response.id == movieId) {
                        movie = Movies(
                            response.name,
                            response.viewerRating,
                            response.genre,
                            response.year,
                            response.description,
                            response.image,
                            response.id
                        )
                    }
                }
                result.postValue(movie)
            }
        })

        return result
    }

    override fun getTvShowList(): LiveData<Resource<PagedList<TvShow>>> {
        return object :
            NetworkBoundResource<PagedList<TvShow>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShow>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShow>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShows()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvshowList = ArrayList<TvShow>()
                for (response in data) {
                    val tvshow = TvShow(
                        response.name,
                        response.viewerRating,
                        response.genre,
                        response.year,
                        response.description,
                        response.image,
                        response.id
                    )
                    tvshowList.add(tvshow)
                }

                localDataSource.insertTvShows(tvshowList)
            }
        }.asLiveData()
    }

    override fun getTvShowDetail(tvshowId: String): LiveData<TvShow> {
        val result = MutableLiveData<TvShow>()

        remoteDataSource.getCallbackTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvshowResponse: List<TvShowResponse>) {
                var tvShow = TvShow()
                for (response in tvshowResponse) {
                    if (response.id == tvshowId) {
                        tvShow = TvShow(
                            response.name,
                            response.viewerRating,
                            response.genre,
                            response.year,
                            response.description,
                            response.image,
                            response.id
                        )
                    }
                }
                result.postValue(tvShow)
            }
        })

        return result
    }

    override fun insertMovie(movieEntity: Movies): Long {
        return localDataSource.insertMovie(movieEntity)
    }

    override fun insertTvShow(tvShowEntity: TvShow): Long {
        return localDataSource.insertTvShow(tvShowEntity)
    }

    override fun getMoviesFromDb(): LiveData<PagedList<Movies>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getTvShowFromDb(): LiveData<PagedList<TvShow>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun getMovieByIdFromDb(id: String): LiveData<Movies> {
        return localDataSource.getMovieById(id)
    }

    override fun getTvShowByIdFromDb(id: String): LiveData<TvShow> {
        return localDataSource.getTvShowById(id)
    }

    override fun movieFavoriteState(id: String, isFavorite: Boolean) {
        localDataSource.favoriteMovie(id, isFavorite)
    }

    override fun tvShowFavoriteState(id: String, isFavorite: Boolean) {
        localDataSource.favoriteTvShow(id, isFavorite)
    }
}