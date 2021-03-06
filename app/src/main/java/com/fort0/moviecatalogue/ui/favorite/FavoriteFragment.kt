package com.fort0.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.databinding.FragmentFavoriteBinding
import com.fort0.moviecatalogue.ui.favorite.movie.FavoriteMovieFragment
import com.fort0.moviecatalogue.ui.favorite.tvshow.FavoriteTvShowFragment


class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        val adapter = FavoritePagerAdapter(childFragmentManager)
        adapter.addFragment(FavoriteTvShowFragment(), getString(R.string.tvshow_tab))
        adapter.addFragment(FavoriteMovieFragment(), getString(R.string.movie_tab))
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        return binding.root
    }
}