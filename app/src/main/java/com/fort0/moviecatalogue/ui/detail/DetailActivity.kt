package com.fort0.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.databinding.ActivityDetailBinding
import com.fort0.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var isFavorite: Boolean = false

    companion object {
        const val EXTRA_CONTENT = "extra_content"
        const val EXTRA_ATTRIBUTE = "extra_attribute"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE
        binding.ivImageDetail.visibility = View.INVISIBLE
        binding.cardView.visibility = View.INVISIBLE
        binding.info.visibility = View.INVISIBLE

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        val intent = intent.extras
        if (intent != null) {
            val content = intent.getString(EXTRA_CONTENT)
            val attribute = intent.getString(EXTRA_ATTRIBUTE)
            val tvshow: TvShow? = null
            val movie: Movies? = null

            if (attribute.equals(R.string.movie.toString(), ignoreCase = true)) {
                if (content != null) {
                    viewModel.setSelectedItem(content)
                    viewModel.getMovie().observe(this, { movies ->
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.ivImageDetail.visibility = View.VISIBLE
                        binding.cardView.visibility = View.VISIBLE
                        binding.info.visibility = View.VISIBLE
                        getMovieDetail(movies)
                    })

                    viewModel.getMoviesFromDb().observe(this) {
                        if (it != null) {
                            if (it.isFavorite) {
                                binding.fabFavorites.setImageDrawable(
                                    ContextCompat.getDrawable(
                                        this@DetailActivity, R.drawable.ic_baseline_favorite_24
                                    )
                                )
                                isFavorite = true
                            } else {
                                binding.fabFavorites.setImageDrawable(
                                    ContextCompat.getDrawable(
                                        this@DetailActivity,
                                        R.drawable.ic_baseline_favorite_border_24
                                    )
                                )
                                isFavorite = false
                            }
                        }
                    }

                    binding.fabFavorites.setOnClickListener {
                        if (isFavorite) {
                            GlobalScope.launch {
                                if (movie != null) {
                                    viewModel.deleteMovieFromFavorite(movie)
                                }
                            }

                            Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show()

                        } else {
                            GlobalScope.launch {
                                if (movie != null) {
                                    viewModel.addMovieToFavorite(movie)
                                }
                            }

                            Toast.makeText(this, "Removed from favorite", Toast.LENGTH_SHORT).show()

                        }

                        isFavorite = !isFavorite
                    }
                }
            }

            if (attribute.equals(R.string.tvshow.toString(), ignoreCase = true)) {
                if (content != null) {
                    viewModel.setSelectedItem(content)
                    viewModel.getTvShow().observe(this, { tvshows ->
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.ivImageDetail.visibility = View.VISIBLE
                        binding.cardView.visibility = View.VISIBLE
                        binding.info.visibility = View.VISIBLE
                        getTvShowDetail(tvshows)
                    })

                    binding.fabFavorites.setOnClickListener {
                        if (isFavorite) {
                            GlobalScope.launch {
                                if (tvshow != null) {
                                    viewModel.deleteTvShowFromFavorite(tvshow)
                                    Toast.makeText(
                                        applicationContext,
                                        "Added to favorite",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }


                        } else {
                            GlobalScope.launch {
                                if (tvshow != null) {
                                    viewModel.addTvShowToFavorite(tvshow)
                                    Toast.makeText(
                                        applicationContext,
                                        "Removed from favorite",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                }
                            }
                        }

                        isFavorite = !isFavorite
                    }
                }
            }
        }
    }

    private fun getMovieDetail(movies: Movies) {
        Glide.with(this)
            .load(movies.image)
            .into(binding.ivImageDetail)

        binding.tvTitle.text = movies.name
        binding.tvGenre.text = movies.genre
        binding.tvDesc.text = movies.description
        binding.tvYear.text = movies.year
        binding.tvRating.text = movies.viewerRating

    }

    private fun getTvShowDetail(tvshow: TvShow) {
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