package com.fort0.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fort0.moviecatalogue.data.source.remote.RemoteDataSource
import com.fort0.moviecatalogue.utils.LiveDataTestUtil
import com.fort0.moviecatalogue.utils.MovieData
import com.fort0.moviecatalogue.utils.TvShowData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.doAnswer

class RepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repository = FakeRepository(remote)

    private val movieResponses = MovieData.generateRemoteMovieList()
    private val tvshowResponse = TvShowData.generateRemoteTvShowList()

    private val movieId = movieResponses[0].id
    private val tvshowId = tvshowResponse[0].id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() // asynchronous

    @Test
    fun getMovieList() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getCallbackMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(repository.getMovieList())
        verify(remote).getCallbackMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())

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
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvshowResponse)
            null
        }.`when`(remote).getCallbackTvShow(any())
        val tvshowEntities = LiveDataTestUtil.getValue(repository.getTvShowList())
        verify(remote).getCallbackTvShow(any())
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponse.size.toLong(), tvshowEntities.size.toLong())
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