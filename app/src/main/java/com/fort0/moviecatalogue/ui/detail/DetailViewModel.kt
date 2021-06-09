package com.fort0.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.data.TvShow
import com.fort0.moviecatalogue.utils.MovieData
import com.fort0.moviecatalogue.utils.TvShowData

class DetailViewModel : ViewModel() {
    private lateinit var tvShows: TvShow
    private lateinit var movies: Movies

    companion object {
        const val MOVIES = "movies"
        const val TV_SHOWS = "tvshow"
    }

    fun getMovieDetail() = movies
    fun getTvShowDetail() = tvShows

    fun setMovieList(id: String) {
        for (movie in MovieData.generateMovieList()) {
            if (movie.id == id) {
                movies = movie
            }
        }
    }

    fun setTvShowList(id: String) {
        for (tvShow in TvShowData.generateTvShowList()) {
            if (tvShow.id == id) {
                tvShows = tvShow
            }
        }
    }
}