package com.canonal.movie.ui.movieHome

import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.canonal.movie.R
import com.canonal.movie.databinding.FragmentHomeMovieBinding
import com.canonal.movie.di.AppModule
import com.canonal.movie.ui.base.BaseFragment
import com.canonal.movie.ui.movieHome.adapter.PopularMovieAdapter
import com.canonal.movie.util.collectLatestLifecycleAwareStateFlow
import com.canonal.movie.util.initializeRecyclerView

class MovieHomeFragment :
    BaseFragment<FragmentHomeMovieBinding>(FragmentHomeMovieBinding::inflate) {

    private val homeMovieViewModel: HomeMovieViewModel by viewModels {
        HomeMovieViewModelFactory(AppModule.getPopularMovieRepository())
    }

    override fun initUi() {
        homeMovieViewModel.getPopularMovies()
        collectLatestLifecycleAwareStateFlow(
            homeMovieViewModel.popularMovieListState
        ) { popularMovieListState ->

            if (popularMovieListState.movieList.isEmpty().not()) {
                initializeRecyclerView(
                    binding.rvPopularMovie,
                    PopularMovieAdapter(popularMovieListState.movieList),
                    LinearLayoutManager(requireContext())
                )
            } else {
                binding.tvError.text = popularMovieListState.errorMessage
                binding.tvError.visibility = View.VISIBLE
                binding.ivError.visibility = View.VISIBLE
            }

        }
    }


}