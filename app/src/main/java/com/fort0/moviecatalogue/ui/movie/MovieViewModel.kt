package com.fort0.moviecatalogue.ui.movie

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.utils.MovieData

class MovieViewModel : ViewModel() {
    private var movieId: Int? = null

    fun getMovie(): Movies {
        lateinit var movie: Movies
        val movies = MovieData.generateMovieList()
        for (movieItem in movies) {
            if (movieItem.id == movieId) {
                movie = movieItem
            }
        }
        return movie
    }

    fun setMovie(movieId: Int) {
        this.movieId = movieId
    }

}