package com.fort0.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.TvShow

class TvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getTvShowList(): LiveData<List<TvShow>> = repository.getTvShowList()
}