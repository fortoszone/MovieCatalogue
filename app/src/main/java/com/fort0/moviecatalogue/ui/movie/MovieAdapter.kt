package com.fort0.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.databinding.ItemRowBinding
import com.fort0.moviecatalogue.ui.detail.DetailActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val items = ArrayList<Movies>()

    fun setItems(movie: ArrayList<Movies>?) {
        if (movie.isNullOrEmpty()) return
        this.items.addAll(movie)

    }

    inner class MovieViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movies) {
            with(binding) {
                tvName.text = movie.name
                rating.text = movie.viewerRating
                tvYear.text = movie.year

                Glide.with(itemView.context)
                    .load(movie.image)
                    .into(ivImageDetail)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIES, movie.id)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding: ItemRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
