package com.fort0.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.data.TvShow
import com.fort0.moviecatalogue.utils.MovieData
import com.fort0.moviecatalogue.utils.TvShowData

class TvShowViewModel : ViewModel() {
    private var tvShowId: Int? = null
    fun getTvShow(): TvShow {
        lateinit var tvShow: TvShow
        val tvShows = TvShowData.generateTvShowList()
        for (tvShowItem in tvShows) {
            if (tvShowItem.id == tvShowId) {
                tvShow = tvShowItem
            }
        }
        return tvShow
    }

    fun setTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }
}