package com.fort0.moviecatalogue.ui.favorite.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.databinding.ItemRowBinding
import com.fort0.moviecatalogue.ui.detail.DetailActivity

class FavoriteMovieAdapter :
    PagedListAdapter<Movies, FavoriteMovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {
    private val items = ArrayList<Movies>()

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Movies> =
            object : DiffUtil.ItemCallback<Movies>() {
                override fun areItemsTheSame(old: Movies, new: Movies): Boolean {
                    return old.id == new.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(old: Movies, new: Movies): Boolean {
                    return old == new
                }
            }
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
                    intent.putExtra(DetailActivity.EXTRA_CONTENT, movie.id)
                    intent.putExtra(DetailActivity.EXTRA_ATTRIBUTE, R.string.movie.toString())

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
