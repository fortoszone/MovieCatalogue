package com.fort0.moviecatalogue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.databinding.ItemRowBinding
import com.fort0.moviecatalogue.ui.movie.MovieFragment

class MovieAdapter(private val listMovie: MovieFragment) :
    RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {
    private val items = ArrayList<Movies>()

    fun setItems(items: ArrayList<Movies>?) {
        this.items.clear()
        if (items != null) {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movies) {
            with(binding) {
                name.text = movie.name
                rating.text = movie.viewerRating
                year.text = movie.year

                Glide.with(itemView.context)
                    .load(movie.image)
                    .into(image)

                /*itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, movie.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, DetailViewModel.MOVIE)

                    itemView.context.startActivity(intent)*/
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: ItemRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
