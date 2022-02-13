package com.canonal.movie.ui.movieHome

import androidx.lifecycle.ViewModel
import com.canonal.movie.repository.PopularMovieRepository

class HomeMovieViewModel(
    private val popularMovieRepository: PopularMovieRepository
) : ViewModel(){

    fun getPopularMovies() = popularMovieRepository.getPopularMovies()
}