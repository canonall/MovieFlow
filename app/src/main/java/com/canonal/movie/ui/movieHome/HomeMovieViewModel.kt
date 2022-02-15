package com.canonal.movie.ui.movieHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canonal.movie.repository.PopularMovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeMovieViewModel(
    private val popularMovieRepository: PopularMovieRepository
) : ViewModel() {

    private val _popularMovieList = MutableStateFlow(PopularMovieListState())
    val popularMovieList: StateFlow<PopularMovieListState>
        get() = _popularMovieList.asStateFlow()

    fun getPopularMovies() {
        viewModelScope.launch {
            popularMovieRepository.popularMovieResponse
                .collectLatest { popularMovieResponse ->
                    _popularMovieList.value = popularMovieList.value.copy(
                        movieList = popularMovieResponse.movie,
                        isLoading = false,
                    )
                }
        }
    }
}