package com.fort0.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.databinding.ItemRowBinding
import com.fort0.moviecatalogue.ui.detail.DetailActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {
    private val items = ArrayList<TvShow>()

    fun setItems(tvShow: List<TvShow>?) {
        if (tvShow.isNullOrEmpty()) return
        this.items.addAll(tvShow)

    }

    inner class ListViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                tvName.text = tvShow.name
                rating.text = tvShow.viewerRating
                tvYear.text = tvShow.year

                Glide.with(itemView.context)
                    .load(tvShow.image)
                    .into(ivImageDetail)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_CONTENT, tvShow.id)
                    intent.putExtra(DetailActivity.EXTRA_ATTRIBUTE, R.string.tvshow.toString())

                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: ItemRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
