package com.fort0.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fort0.moviecatalogue.*
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.data.TvShow
import com.fort0.moviecatalogue.ui.movie.MovieViewModel
import com.fort0.moviecatalogue.utils.TvShowData

class TvShowFragment : Fragment() {

    private var tvShowList: ArrayList<TvShow> = arrayListOf()
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_tvshow, container, false)
        val rvTvShow = root.findViewById<View>(R.id.rv_tvshow) as RecyclerView
        rvTvShow.layoutManager = LinearLayoutManager(activity)

        viewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)
        val tvShow = viewModel.getTvShow()

        adapter = TvShowAdapter(tvShowList)
        adapter.setItems(tvShow)

        val tvShowAdapter = TvShowAdapter(tvShowList)
        rvTvShow.adapter = tvShowAdapter
        return root
    }
}