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
            .into(binding.ivImageDetail)

        binding.tvTitle.text = movies.name
        binding.tvGenre.text = movies.genre
        binding.tvDesc.text = movies.description
        binding.tvYear.text = movies.year
        binding.tvRating.text = movies.viewerRating

    }

    fun getTvShowDetail(tvshow: TvShow) {
        Glide.with(this)
            .load(tvshow.image)
            .into(binding.ivImageDetail)

        binding.tvTitle.text = tvshow.name
        binding.tvGenre.text = tvshow.genre
        binding.tvDesc.text = tvshow.description
        binding.tvYear.text = tvshow.year
        binding.tvRating.text = tvshow.viewerRating
    }

}