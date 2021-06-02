package com.fort0.moviecatalogue

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val list = ArrayList<Fragment>()
    private val titleList = ArrayList<String>()


    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        list.add(fragment)
        titleList.add(title)
    }
}