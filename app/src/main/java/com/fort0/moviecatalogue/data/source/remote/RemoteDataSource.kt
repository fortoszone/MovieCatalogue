package com.fort0.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fort0.moviecatalogue.EspressoIdlingResource
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

    fun getCallbackTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvShowReceived(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getCallbackMovie(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvshowResponse: List<TvShowResponse>)
    }

    interface LoadMovieCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({
            result.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return result
    }

    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            result.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return result
    }

}