package com.fort0.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.databinding.FragmentTvshowBinding
import com.fort0.moviecatalogue.utils.Status
import com.fort0.moviecatalogue.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {
    private lateinit var binding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        binding = FragmentTvshowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShowList().observe(viewLifecycleOwner, { tvshows ->
                when (tvshows.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE

                    Status.SUCCESS -> {
                        binding.rvTvshow.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.INVISIBLE
                        tvShowAdapter.submitList(tvshows.data)
                        tvShowAdapter.notifyDataSetChanged()
                    }

                    Status.ERROR -> Log.e("error", tvshows.message.toString())
                }
            })

            with(binding.rvTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }
}