package com.fort0.moviecatalogue.ui.detail

import com.fort0.moviecatalogue.utils.MovieData
import com.fort0.moviecatalogue.utils.TvShowData
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private var movies = MovieData.generateMovieList()[0]
    private var tvShow = TvShowData.generateTvShowList()[0]

    private val movieId = movies.id
    private val tvShowId = tvShow.id

    @Test
    fun getMovieDetail() {
        viewModel.setMovieList(movieId)
        val movie = viewModel.getMovieDetail()
        Assert.assertNotNull(movie)
        assertEquals(movies.id, movie.id)
        assertEquals(movies.image, movie.image)
        assertEquals(movies.name, movie.name)
        assertEquals(movies.year, movie.year)
        assertEquals(movies.viewerRating, movie.viewerRating)
        assertEquals(movies.genre, movie.genre)
        assertEquals(movies.description, movie.description)
    }

    @Test
    fun getTvShowDetail() {
        viewModel.setTvShowList(tvShowId)
        val tvshow = viewModel.getTvShowDetail()
        Assert.assertNotNull(tvshow)
        assertEquals(tvShow.id, tvshow.id)
        assertEquals(tvShow.image, tvshow.image)
        assertEquals(tvShow.name, tvshow.name)
        assertEquals(tvShow.year, tvshow.year)
        assertEquals(tvShow.viewerRating, tvshow.viewerRating)
        assertEquals(tvShow.genre, tvshow.genre)
        assertEquals(tvShow.description, tvshow.description)
    }

    @Before
    fun setMovieList() {
        viewModel = DetailViewModel()
        viewModel.setMovieList(movieId)
    }

    @Before
    fun setTvShowList() {
        viewModel = DetailViewModel()
        viewModel.setTvShowList(tvShowId)
    }
}