package com.fort0.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fort0.moviecatalogue.data.source.Repository
import com.fort0.moviecatalogue.di.Injection
import com.fort0.moviecatalogue.ui.detail.DetailViewModel
import com.fort0.moviecatalogue.ui.favorite.movie.FavoriteMovieViewModel
import com.fort0.moviecatalogue.ui.favorite.tvshow.FavoriteTvShowViewModel
import com.fort0.moviecatalogue.ui.movie.MovieViewModel
import com.fort0.moviecatalogue.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(repository) as T
            }

            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(repository) as T
            }

            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(repository) as T
            }

            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                return FavoriteMovieViewModel(repository) as T
            }

            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                return FavoriteTvShowViewModel(repository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}
