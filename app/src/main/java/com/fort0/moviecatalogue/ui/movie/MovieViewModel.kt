package com.fort0.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.Movies

class MovieViewModel(private val repository: Repository) : ViewModel() {
    fun getMovieList(): LiveData<List<Movies>> = repository.getMovieList()
}