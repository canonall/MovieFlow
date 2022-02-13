package com.canonal.movie.ui.movieHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.canonal.movie.repository.PopularMovieRepository

class HomeMovieViewModelFactory(
    private val popularMovieRepository: PopularMovieRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeMovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeMovieViewModel(popularMovieRepository) as T
        }
        throw IllegalArgumentException("HomeMovieViewModelFactory Error")
    }
}