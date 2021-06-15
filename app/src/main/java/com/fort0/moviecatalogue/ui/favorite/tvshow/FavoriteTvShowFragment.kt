package com.fort0.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.databinding.FragmentTvshowBinding
import com.fort0.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {
    private lateinit var binding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTvshowBinding.inflate(inflater, container, false)

        binding.rvTvshow.visibility = View.INVISIBLE
        binding.progressBar.visibility = View.VISIBLE

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]
            val tvShowAdapter = FavoriteTvShowAdapter()

            viewModel.getTvShowList().observe(viewLifecycleOwner, { tvshow ->
                binding.rvTvshow.visibility = View.VISIBLE
                binding.progressBar.visibility = View.INVISIBLE
                tvShowAdapter.setItems(tvshow)
                tvShowAdapter.notifyDataSetChanged()
            })

            with(binding.rvTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }
}