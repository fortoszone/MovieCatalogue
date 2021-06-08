package com.fort0.moviecatalogue.ui.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovieList() {
        val movie = viewModel.getMovieList()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }
}