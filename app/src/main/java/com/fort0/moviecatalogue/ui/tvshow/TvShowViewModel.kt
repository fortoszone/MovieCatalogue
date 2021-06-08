package com.fort0.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.fort0.moviecatalogue.utils.TvShowData

class TvShowViewModel : ViewModel() {
    fun getTvShowList() = TvShowData.generateTvShowList()
}