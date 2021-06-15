package com.fort0.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.utils.MovieData
import com.fort0.moviecatalogue.utils.TvShowData
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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() //asynchronous

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<List<TvShow>>


    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getMovieList() {
        val dummyTvShow = TvShowData.generateTvShowList()
        val tvshow = MutableLiveData<List<TvShow>>()
        tvshow.value = dummyTvShow

        Mockito.`when`(repository.getTvShowList()).thenReturn(tvshow)
        val tvShowList = viewModel.getTvShowList().value
        Mockito.verify(repository).getTvShowList()

        assertNotNull(tvShowList)
        assertEquals(10, tvShowList?.size)

        viewModel.getTvShowList().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}