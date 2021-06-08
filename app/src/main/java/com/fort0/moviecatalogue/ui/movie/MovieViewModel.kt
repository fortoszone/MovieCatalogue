package com.fort0.moviecatalogue.ui.movie

import android.graphics.Movie
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.utils.MovieData

class MovieViewModel : ViewModel() {
    fun getMovieList() = MovieData.generateMovieList()
}