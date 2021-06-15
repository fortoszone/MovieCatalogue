package com.fort0.moviecatalogue.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.ui.favorite.movie.FavoriteMovieFragment
import com.fort0.moviecatalogue.ui.favorite.tvshow.FavoriteTvShowFragment

class FavoritePagerAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.title_tv_show, R.string.title_movies)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteTvShowFragment()
            1 -> FavoriteMovieFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        context.resources.getString(TAB_TITLES[position])

}