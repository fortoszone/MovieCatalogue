package com.fort0.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.utils.Resource

interface DataSource {
    fun getMovieList(): LiveData<Resource<PagedList<Movies>>>
    fun getMovieDetail(movieId: String): LiveData<Movies>

    fun getTvShowList(): LiveData<Resource<PagedList<TvShow>>>
    fun getTvShowDetail(tvshowId: String): LiveData<TvShow>
    fun addTvShowToFavorite(id: String, isFavorite: Boolean)
    fun addMovieToFavorite(id: String, isFavorite: Boolean)
    fun getTvShowByIdFromDb(id: String): LiveData<TvShow>
    fun getMovieByIdFromDb(id: String): LiveData<Movies>
    fun getTvShowFromDb(): LiveData<PagedList<TvShow>>
    fun getMoviesFromDb(): LiveData<PagedList<Movies>>
    fun insertTvShow(tvShowEntity: TvShow): Long
    fun insertMovie(movieEntity: Movies): Long
}