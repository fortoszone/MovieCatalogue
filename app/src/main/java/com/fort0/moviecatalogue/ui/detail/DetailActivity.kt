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

            if (attribute.equals(R.string.movie.toString(), ignoreCase = true)) {
                if (content != null) {
                    var movies: Movies? = null
                    viewModel.setSelectedItem(content)
                    viewModel.getMovie().observe(this, { movie ->
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.ivImageDetail.visibility = View.VISIBLE
                        binding.cardView.visibility = View.VISIBLE
                        binding.info.visibility = View.VISIBLE
                        getMovieDetail(movie)
                        movies = movie
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
                            GlobalScope.launch { viewModel.deleteMovieFromFavorite(movies) }
                            Toast.makeText(this, "Removed from favorite", Toast.LENGTH_SHORT).show()
                            binding.fabFavorites.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this@DetailActivity, R.drawable.ic_baseline_favorite_border_24
                                )
                            )

                        } else {
                            GlobalScope.launch { viewModel.addMovieToFavorite(movies) }
                            Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show()
                            binding.fabFavorites.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this@DetailActivity,
                                    R.drawable.ic_baseline_favorite_24
                                )
                            )
                        }

                        isFavorite = !isFavorite
                    }
                }
            }

            if (attribute.equals(R.string.tvshow.toString(), ignoreCase = true)) {
                if (content != null) {
                    var tvshows: TvShow? = null
                    viewModel.setSelectedItem(content)
                    viewModel.getTvShow().observe(this, { tvshow ->
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.ivImageDetail.visibility = View.VISIBLE
                        binding.cardView.visibility = View.VISIBLE
                        binding.info.visibility = View.VISIBLE
                        getTvShowDetail(tvshow)
                        tvshows = tvshow
                    })

                    viewModel.getTvShowFromDb().observe(this) {
                        if (it != null) {
                            Toast.makeText(this, "$isFavorite", Toast.LENGTH_SHORT).show()
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
                            GlobalScope.launch { viewModel.deleteTvShowFromFavorite(tvshows) }
                            Toast.makeText(
                                applicationContext,
                                "Removed from favorite",
                                Toast.LENGTH_SHORT
                            ).show()

                            binding.fabFavorites.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this@DetailActivity, R.drawable.ic_baseline_favorite_border_24
                                )
                            )
                        } else {
                            GlobalScope.launch { viewModel.addTvShowToFavorite(tvshows) }
                            Toast.makeText(
                                applicationContext,
                                "Added to favorite",
                                Toast.LENGTH_SHORT
                            ).show()

                            binding.fabFavorites.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this@DetailActivity,
                                    R.drawable.ic_baseline_favorite_24
                                )
                            )
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