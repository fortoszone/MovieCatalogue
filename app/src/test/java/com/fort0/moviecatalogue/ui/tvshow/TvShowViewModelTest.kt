package com.fort0.moviecatalogue.ui.tvshow

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel


    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getMovieList() {
        val tvShow = viewModel.getTvShowList()
        assertNotNull(tvShow)
        assertEquals(10, tvShow.size)
    }
}