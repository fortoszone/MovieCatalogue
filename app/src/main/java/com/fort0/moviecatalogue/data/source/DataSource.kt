package com.fort0.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow

interface DataSource {
    fun getMovieList(): LiveData<List<Movies>>
    fun getMovieDetail(movieId: String): LiveData<Movies>

    fun getTvShowList(): LiveData<List<TvShow>>
    fun getTvShowDetail(tvshowId: String): LiveData<TvShow>
}