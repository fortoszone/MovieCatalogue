package com.fort0.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.TvShow

class FavoriteTvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getTvShowList(): LiveData<PagedList<TvShow>> = repository.getTvShowFromDb()
}