package com.fort0.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.databinding.ActivityDetailBinding
import com.fort0.moviecatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

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
                    viewModel.setSelectedItem(content)
                    viewModel.getMovie().observe(this, { movies ->
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.ivImageDetail.visibility = View.VISIBLE
                        binding.cardView.visibility = View.VISIBLE
                        binding.info.visibility = View.VISIBLE
                        getMovieDetail(movies)
                    })
                }
            }

            if (attribute.equals(R.string.tvshow.toString(), ignoreCase = true)) {
                if (content != null) {
                    viewModel.setSelectedItem(content)
                    viewModel.getTvShow().observe(this, { tvshow ->
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.ivImageDetail.visibility = View.VISIBLE
                        binding.cardView.visibility = View.VISIBLE
                        binding.info.visibility = View.VISIBLE
                        getTvShowDetail(tvshow)
                    })
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