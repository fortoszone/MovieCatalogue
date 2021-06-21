package com.fort0.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.utils.MovieData
import com.fort0.moviecatalogue.utils.TvShowData
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private var movies = MovieData.generateMovieList()[0]
    private var tvShows = TvShowData.generateTvShowList()[0]
    private val movieId = movies.id
    private val tvShowId = tvShows.id
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() //asynchronous

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var movieObserver: Observer<Movies>

    @Mock
    private lateinit var tvshowObserver: Observer<TvShow>

    @Before
    fun setList() {
        viewModel = DetailViewModel(repository)
        viewModel.setSelectedItem(movieId)
    }

    @Before
    fun setTvShowList() {
        viewModel = DetailViewModel(repository)
        viewModel.setSelectedItem(tvShowId)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<Movies>()
        movie.value = movies

        `when`(repository.getMovieDetail(movieId)).thenReturn(movie)
        viewModel.setSelectedItem(movieId)
        val movieList = viewModel.getMovie().value as Movies
        verify(repository).getMovieDetail(movieId)

        Assert.assertNotNull(movieList)
        assertEquals(movies.id, movieList.id)
        assertEquals(movies.image, movieList.image)
        assertEquals(movies.name, movieList.name)
        assertEquals(movies.year, movieList.year)
        assertEquals(movies.viewerRating, movieList.viewerRating)
        assertEquals(movies.genre, movieList.genre)
        assertEquals(movies.description, movieList.description)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(movies)
    }

    @Test
    fun getTvShowDetail() {
        val tvshow = MutableLiveData<TvShow>()
        tvshow.value = tvShows

        `when`(repository.getTvShowDetail(tvShowId)).thenReturn(tvshow)
        viewModel.setSelectedItem(tvShowId)
        val tvShowList = viewModel.getTvShow().value as TvShow
        verify(repository).getTvShowDetail(movieId)

        Assert.assertNotNull(tvShowList)
        assertEquals(tvShows.id, tvShowList.id)
        assertEquals(tvShows.image, tvShowList.image)
        assertEquals(tvShows.name, tvShowList.name)
        assertEquals(tvShows.year, tvShowList.year)
        assertEquals(tvShows.viewerRating, tvShowList.viewerRating)
        assertEquals(tvShows.genre, tvShowList.genre)
        assertEquals(tvShows.description, tvShowList.description)

        viewModel.getTvShow().observeForever(tvshowObserver)
        verify(tvshowObserver).onChanged(tvShows)
    }

    @Test
    fun getMovieById() {
        val dummyMovie = MutableLiveData<Movies>()
        dummyMovie.value = movies
        viewModel.setSelectedItem(movieId)

        `when`(repository.getMovieByIdFromDb(movieId)).thenReturn(dummyMovie)
        val movie = viewModel.getMoviesFromDb().value
        verify(repository).getMovieByIdFromDb(movieId)
        Assert.assertNotNull(movie)

        viewModel.getMoviesFromDb().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie.value)
    }

    @Test
    fun getTvShowsById() {
        val dummyTvShow = MutableLiveData<TvShow>()
        dummyTvShow.value = tvShows
        viewModel.setSelectedItem(tvShowId)

        `when`(repository.getTvShowByIdFromDb(tvShowId)).thenReturn(dummyTvShow)
        val tvshow = viewModel.getTvShowFromDb().value
        verify(repository).getTvShowByIdFromDb(tvShowId)
        Assert.assertNotNull(tvshow)

        viewModel.getTvShowFromDb().observeForever(tvshowObserver)
        verify(tvshowObserver).onChanged(dummyTvShow.value)
    }
}