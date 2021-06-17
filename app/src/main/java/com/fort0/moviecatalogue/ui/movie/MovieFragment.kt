package com.fort0.moviecatalogue.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.databinding.FragmentMovieBinding
import com.fort0.moviecatalogue.utils.Status
import com.fort0.moviecatalogue.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = MovieAdapter()

            viewModel.getMovieList().observe(viewLifecycleOwner, { movies ->
                when (movies.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE

                    Status.SUCCESS -> {
                        binding.rvMovies.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.INVISIBLE
                        movieAdapter.submitList(movies.data)
                        movieAdapter.notifyDataSetChanged()
                        Toast.makeText(context, "${movies.data}", Toast.LENGTH_SHORT).show()
                    }

                    Status.ERROR -> Log.e("error", movies.message.toString())
                }
            })

            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }
}