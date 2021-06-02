package com.fort0.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fort0.moviecatalogue.MovieAdapter
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {
    private var movieList: ArrayList<Movies> = arrayListOf()
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {

        val root: View = inflater.inflate(R.layout.fragment_movie, container, false)
        val rvMovies = root.findViewById<View>(R.id.rv_movies) as RecyclerView
        rvMovies.layoutManager = LinearLayoutManager(activity)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        val movies = viewModel.getMovie()

        adapter = MovieAdapter(movieList)
        adapter.setItems(movies)

        val movieAdapter = MovieAdapter(movieList)
        rvMovies.adapter = movieAdapter
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movieItem = viewModel.getMovie()
            val movieAdapter = MovieAdapter(movieItem)
            movieAdapter.setItems(movieItem)

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }

    }
}