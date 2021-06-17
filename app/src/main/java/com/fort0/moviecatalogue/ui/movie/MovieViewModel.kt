package com.fort0.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.utils.Resource

class MovieViewModel(private val repository: Repository) : ViewModel() {
    fun getMovieList(): LiveData<Resource<PagedList<Movies>>> = repository.getMovieList()
}