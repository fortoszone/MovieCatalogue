package com.fort0.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.data.TvShow
import com.fort0.moviecatalogue.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TVSHOW = "extra_tvshows"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        val intent = intent.extras
        if (intent != null) {
            val extraTvShow = intent.getString(EXTRA_TVSHOW)
            val extraMovies = intent.getString(EXTRA_MOVIES)

            if (extraTvShow != null) {
                viewModel.setTvShowList(extraTvShow)
                val tvshow = viewModel.getTvShowDetail()
                getTvShowDetail(tvshow)
            } else if (extraMovies != null) {
                viewModel.setMovieList(extraMovies)
                val movie = viewModel.getMovieDetail()
                getMovieDetail(movie)
            }
        }
    }

    fun getMovieDetail(movies: Movies) {
        Glide.with(this)
            .load(movies.image)
            .into(binding.image)

        binding.title.text = movies.name
        binding.genre.text = movies.genre
        binding.desc.text = movies.description
        binding.year.text = movies.year

    }

    fun getTvShowDetail(tvshow: TvShow) {
        Glide.with(this)
            .load(tvshow.image)
            .into(binding.image)

        binding.title.text = tvshow.name
        binding.genre.text = tvshow.genre
        binding.desc.text = tvshow.description
        binding.year.text = tvshow.year
    }

}