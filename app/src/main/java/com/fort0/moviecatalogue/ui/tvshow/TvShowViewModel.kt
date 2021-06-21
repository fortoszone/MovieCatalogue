package com.fort0.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.utils.Resource

class TvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getTvShowList(): LiveData<Resource<PagedList<TvShow>>> = repository.getTvShowList()
}