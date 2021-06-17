package com.fort0.moviecatalogue.ui.favorite.tvshow

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.databinding.ItemRowBinding
import com.fort0.moviecatalogue.ui.detail.DetailActivity

class FavoriteTvShowAdapter :
    PagedListAdapter<TvShow, FavoriteTvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {
    private val items = ArrayList<TvShow>()

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TvShow> =
            object : DiffUtil.ItemCallback<TvShow>() {
                override fun areItemsTheSame(old: TvShow, new: TvShow): Boolean {
                    return old.id == new.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(old: TvShow, new: TvShow): Boolean {
                    return old == new
                }
            }
    }

    inner class TvShowViewHolder(private val binding: ItemRowBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding: ItemRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}
