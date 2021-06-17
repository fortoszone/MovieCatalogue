package com.fort0.moviecatalogue.di

import android.content.Context
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.remote.RemoteDataSource
import com.fort0.moviecatalogue.room.AppDatabase
import com.fort0.moviecatalogue.room.LocalDataSource
import com.fort0.moviecatalogue.utils.AppExecutors
import com.fort0.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): Repository {
        val db = AppDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(db.movieDao(), db.tvShowDao())
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}