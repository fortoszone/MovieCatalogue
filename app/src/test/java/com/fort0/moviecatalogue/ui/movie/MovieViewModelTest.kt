package com.fort0.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() //asynchronous

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Movies>>>

    @Mock
    private lateinit var pagedList: PagedList<Movies>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovieList() {
        val dummyMovies = Resource.success(pagedList)
        Mockito.`when`(dummyMovies.data?.size).thenReturn(5)
        val movie = MutableLiveData<Resource<PagedList<Movies>>>()
        movie.value = dummyMovies

        Mockito.`when`(repository.getMovieList()).thenReturn(movie)
        val movieList = viewModel.getMovieList().value
        Mockito.verify(repository).getMovieList()

        assertNotNull(movieList)
        assertEquals(5, movieList?.data?.size)

        viewModel.getMovieList().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}