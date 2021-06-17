package com.fort0.moviecatalogue.room

import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow

class LocalDataSource private constructor(
    private val movieDao: MovieDao,
    private val tvShowDao: TvShowDao

) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao, tvShowDao: TvShowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao, tvShowDao)
    }

    fun getMovies() = movieDao.getMovies()
    fun getFavoriteMovie() = movieDao.getFavoriteMovie()
    fun getMovieById(id: String) = movieDao.getMovieById(id)
    fun insertMovie(movie: Movies) = movieDao.insertMovie(movie)
    fun insertMovies(movieList: List<Movies>) = movieDao.insertMovies(movieList)
    fun favoriteMovie(id: String, isFavorite: Boolean) =
        movieDao.addMovieToFavorites(id, isFavorite)

    fun getTvShow() = tvShowDao.getTvShow()
    fun getFavoriteTvShow() = tvShowDao.getFavoriteTvShow()
    fun getTvShowById(id: String) = tvShowDao.getTvShowById(id)
    fun insertTvShow(tvShow: TvShow) = tvShowDao.insertTvShow(tvShow)
    fun insertTvShows(tvShowList: List<TvShow>) = tvShowDao.insertTvShows(tvShowList)
    fun favoriteTvShow(id: String, isFavorite: Boolean) =
        tvShowDao.addTvShowToFavorite(id, isFavorite)

}
