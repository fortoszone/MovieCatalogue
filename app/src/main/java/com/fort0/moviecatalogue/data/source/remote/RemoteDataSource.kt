package com.fort0.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import com.fort0.moviecatalogue.EspressoIdlingResources
import com.fort0.moviecatalogue.data.source.remote.response.MovieResponse
import com.fort0.moviecatalogue.data.source.remote.response.TvShowResponse
import com.fort0.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1500

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getCallbackMovie(callback: LoadMovieCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovie())
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getCallbackTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed({
            callback.onAllTvShowReceived(jsonHelper.loadTvShow())
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMovieCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvshowResponse: List<TvShowResponse>)
    }
}