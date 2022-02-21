package com.canonal.movie.ui.movieHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canonal.movie.data.remote.ApiStatus
import com.canonal.movie.repository.PopularMovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeMovieViewModel(
    private val popularMovieRepository: PopularMovieRepository
) : ViewModel() {

    private val _popularMovieListState = MutableStateFlow(PopularMovieListState())
    val popularMovieListState: StateFlow<PopularMovieListState>
        get() = _popularMovieListState.asStateFlow()

    fun getPopularMovies() {
        viewModelScope.launch {
            popularMovieRepository.popularMovieResponse
                .collectLatest { apiStatus ->
                    when (apiStatus) {
                        is ApiStatus.Success -> {
                            _popularMovieListState.value = popularMovieListState.value.copy(
                                movieList = apiStatus.data.movieList,
                                errorMessage = null,
                                isLoading = false,
                            )
                        }
                        is ApiStatus.Error -> {
                            _popularMovieListState.value = popularMovieListState.value.copy(
                                movieList = emptyList(),
                                errorMessage = apiStatus.message,
                                isLoading = false,
                            )
                        }
                        is ApiStatus.Loading -> {
                            _popularMovieListState.value = popularMovieListState.value.copy(
                                movieList = emptyList(),
                                errorMessage = null,
                                isLoading = true,
                            )
                        }
                    }
                }
        }
    }
}