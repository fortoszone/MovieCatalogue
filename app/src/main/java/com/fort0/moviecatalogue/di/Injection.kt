package com.fort0.moviecatalogue.di

import android.content.Context
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.data.source.remote.RemoteDataSource
import com.fort0.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): Repository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return Repository.getInstance(remoteDataSource)
    }
}