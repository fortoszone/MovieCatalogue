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
import org.mockito.Mockito.*

class RepositoryTest {
    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val executor = mock(AppExecutors::class.java)

    private val repository = FakeRepository(remote, local, executor)

    private val movieResponse = MovieData.generateRemoteMovieList()
    private val tvshowResponse = TvShowData.generateRemoteTvShowList()

    private val movieId = movieResponse[0].id
    private val tvshowId = tvshowResponse[0].id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() // asynchronous

    @Test
    fun getMovieList() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movies>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        repository.getMovieList()

        val entities = Resource.success(PagedListUtil.mockPagedList(movieResponse))
        verify(local).getMovies()
        Assert.assertNotNull(entities.data)
        assertEquals(movieResponse.size.toLong(), entities.data?.size?.toLong())

    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getCallbackMovie(any())
        val entities = LiveDataTestUtil.getValue(repository.getMovieDetail(movieId))
        verify(remote).getCallbackMovie(any())
        assertNotNull(entities)
        assertEquals(movieResponse[0].name, entities.name)

    }

    @Test
    fun getTvShowList() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(local.getTvShow()).thenReturn(dataSourceFactory)
        repository.getTvShowList()

        val entities = Resource.success(PagedListUtil.mockPagedList(movieResponse))
        verify(local).getTvShow()
        Assert.assertNotNull(entities.data)
        assertEquals(movieResponse.size.toLong(), entities.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvshowResponse)
            null
        }.`when`(remote).getCallbackTvShow(any())
        val entities = LiveDataTestUtil.getValue(repository.getTvShowDetail(tvshowId))
        verify(remote).getCallbackTvShow(any())
        assertNotNull(entities)
        assertEquals(tvshowResponse[0].name, entities.name)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movies>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        repository.getMoviesFromDb()

        val entities = Resource.success(PagedListUtil.mockPagedList(movieResponse))
        verify(local).getFavoriteMovie()
        Assert.assertNotNull(entities.data)
        assertEquals(movieResponse.size.toLong(), entities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        repository.getTvShowFromDb()

        val entities = Resource.success(PagedListUtil.mockPagedList(tvshowResponse))
        verify(local).getFavoriteTvShow()
        Assert.assertNotNull(entities.data)
        assertEquals(tvshowResponse.size.toLong(), entities.data?.size?.toLong())
    }
}