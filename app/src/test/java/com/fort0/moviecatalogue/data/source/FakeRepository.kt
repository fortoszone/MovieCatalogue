package com.fort0.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.data.source.remote.RemoteDataSource
import com.fort0.moviecatalogue.data.source.remote.response.MovieResponse
import com.fort0.moviecatalogue.data.source.remote.response.TvShowResponse

class FakeRepository(private val remoteDataSource: RemoteDataSource) : DataSource {
    override fun getMovieList(): LiveData<List<Movies>> {
        val result = MutableLiveData<List<Movies>>()

        remoteDataSource.getCallbackMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<Movies>()
                for (response in movieResponse) {
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
                result.postValue(movieList)
            }
        })

        return result
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

    override fun getTvShowList(): LiveData<List<TvShow>> {
        val result = MutableLiveData<List<TvShow>>()

        remoteDataSource.getCallbackTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvshowResponse: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShow>()
                for (response in tvshowResponse) {
                    val movie = TvShow(
                        response.name,
                        response.viewerRating,
                        response.genre,
                        response.year,
                        response.description,
                        response.image,
                        response.id
                    )
                    tvShowList.add(movie)
                }
                result.postValue(tvShowList)
            }
        })

        return result
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
}