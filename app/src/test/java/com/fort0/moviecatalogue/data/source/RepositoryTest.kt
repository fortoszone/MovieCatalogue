package com.fort0.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.fort0.moviecatalogue.PagedListUtil
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.data.source.remote.RemoteDataSource
import com.fort0.moviecatalogue.room.LocalDataSource
import com.fort0.moviecatalogue.utils.*
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.doAnswer

class RepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val executor = Mockito.mock(AppExecutors::class.java)

    private val repository = FakeRepository(remote, local, executor)

    private val movieResponses = MovieData.generateRemoteMovieList()
    private val tvshowResponse = TvShowData.generateRemoteTvShowList()

    private val movieId = movieResponses[0].id
    private val tvshowId = tvshowResponse[0].id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() // asynchronous

    @Test
    fun getMovieList() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movies>
        Mockito.`when`(local.getMovies()).thenReturn(dataSourceFactory)
        repository.getMovieList()

        val entities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getMovies()
        Assert.assertNotNull(entities.data)
        assertEquals(10L, entities.data?.size?.toLong())

    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getCallbackMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(repository.getMovieDetail(movieId))
        verify(remote).getCallbackMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses[0].name, movieEntities.name)

    }

    @Test
    fun getTvShowList() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        Mockito.`when`(local.getTvShow()).thenReturn(dataSourceFactory)
        repository.getTvShowList()

        val entities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getTvShow()
        Assert.assertNotNull(entities.data)
        assertEquals(10L, entities.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvshowResponse)
            null
        }.`when`(remote).getCallbackTvShow(any())
        val tvshowEntities = LiveDataTestUtil.getValue(repository.getTvShowDetail(tvshowId))
        verify(remote).getCallbackTvShow(any())
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponse[0].name, tvshowEntities.name)
    }
}