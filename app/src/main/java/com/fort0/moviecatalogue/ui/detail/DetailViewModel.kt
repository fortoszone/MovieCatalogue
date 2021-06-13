package com.fort0.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow

class DetailViewModel(private val repository: Repository) : ViewModel() {
    lateinit var id: String

    fun setSelectedItem(movieId: String) {
        this.id = movieId
    }

    fun getMovie(): LiveData<Movies> = repository.getMovieDetail(id)

    fun getTvShow(): LiveData<TvShow> = repository.getTvShowDetail(id)
}