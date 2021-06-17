package com.fort0.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow

class DetailViewModel(private val repository: Repository) : ViewModel() {
    lateinit var id: String

    fun setSelectedItem(id: String) {
        this.id = id
    }

    fun getMovie(): LiveData<Movies> = repository.getMovieDetail(id)
    fun getTvShow(): LiveData<TvShow> = repository.getTvShowDetail(id)
    fun getMoviesFromDb() = repository.getMovieByIdFromDb(id)
    fun getTvShowFromDb() = repository.getTvShowByIdFromDb(id)

    fun addMovieToFavorite(movies: Movies?) {
        repository.movieFavoriteState(movies!!.id, true)
    }

    fun addTvShowToFavorite(tvShow: TvShow?) {
        repository.tvShowFavoriteState(tvShow!!.id, true)
    }

    fun deleteMovieFromFavorite(movies: Movies?) {
        repository.movieFavoriteState(movies!!.id, false)
    }

    fun deleteTvShowFromFavorite(tvShow: TvShow?) {
        repository.tvShowFavoriteState(tvShow!!.id, false)
    }
}