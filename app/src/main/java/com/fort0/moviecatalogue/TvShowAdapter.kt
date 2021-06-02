package com.fort0.moviecatalogue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.data.TvShow
import com.fort0.moviecatalogue.databinding.ItemRowBinding

class TvShowAdapter(private val listTvShow: ArrayList<TvShow>) :
    RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {
    private val items = ArrayList<TvShow>()

    fun setItems(items: ArrayList<TvShow>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                name.text = tvShow.name
                rating.text = tvShow.viewerRating
                year.text = tvShow.year

                Glide.with(itemView.context)
                    .load(tvShow.image)
                    .into(image)

                /*itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, movie.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, DetailViewModel.MOVIE)

                    itemView.context.startActivity(intent)*/
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.ListViewHolder {
        val binding: ItemRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return listTvShow.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
