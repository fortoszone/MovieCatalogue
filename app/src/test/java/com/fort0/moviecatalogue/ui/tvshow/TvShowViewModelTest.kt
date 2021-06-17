package com.fort0.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.local.TvShow
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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() //asynchronous

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShow>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShow>


    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShowList() {
        val dummyTvShow = Resource.success(pagedList)
        Mockito.`when`(dummyTvShow.data?.size).thenReturn(5)
        val tvshow = MutableLiveData<Resource<PagedList<TvShow>>>()
        tvshow.value = dummyTvShow

        Mockito.`when`(repository.getTvShowList()).thenReturn(tvshow)
        val tvShowList = viewModel.getTvShowList().value
        Mockito.verify(repository).getTvShowList()

        assertNotNull(tvShowList)
        assertEquals(5, tvShowList?.data?.size)

        viewModel.getTvShowList().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}