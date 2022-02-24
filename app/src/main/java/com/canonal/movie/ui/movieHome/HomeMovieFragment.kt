package com.canonal.movie.ui.movieHome

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.canonal.movie.databinding.FragmentHomeMovieBinding
import com.canonal.movie.ui.base.BaseFragment
import com.canonal.movie.ui.movieHome.adapter.PopularMovieAdapter
import com.canonal.movie.util.collectLatestLifecycleAwareStateFlow
import com.canonal.movie.util.initializeRecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieHomeFragment :
    BaseFragment<FragmentHomeMovieBinding>(FragmentHomeMovieBinding::inflate) {

    private val homeMovieViewModel: HomeMovieViewModel by viewModels()

    override fun initUi() {
        homeMovieViewModel.getPopularMovies()
        setPopularMovieObserver()
    }

    private fun setPopularMovieObserver() {
        collectLatestLifecycleAwareStateFlow(
            homeMovieViewModel.popularMovieListState
        ) { popularMovieListState ->
            when (popularMovieListState.status) {
                PopularMovieListStateStatus.SUCCESS -> {
                    clearUi()
                    initializeRecyclerView(
                        binding.rvPopularMovie,
                        PopularMovieAdapter(popularMovieListState.movieList),
                        LinearLayoutManager(requireContext())
                    )
                }
                PopularMovieListStateStatus.ERROR -> {
                    loadErrorUi(popularMovieListState)
                }
                PopularMovieListStateStatus.LOADING -> {
                    binding.progressBar.isVisible = true
                }
            }
        }
    }

    private fun loadErrorUi(popularMovieListState: PopularMovieListState) {
        binding.rvPopularMovie.isVisible = false
        binding.progressBar.isVisible = false
        binding.tvError.text = popularMovieListState.errorMessage
        binding.tvError.isVisible = true
        binding.ivError.isVisible = true
    }

    private fun clearUi() {
        binding.rvPopularMovie.isVisible = true
        binding.tvError.isVisible = false
        binding.ivError.isVisible = false
        binding.progressBar.isVisible = false
    }


}