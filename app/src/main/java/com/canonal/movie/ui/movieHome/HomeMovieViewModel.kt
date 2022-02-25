package com.canonal.movie.ui.movieHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canonal.movie.data.remote.ApiStatus
import com.canonal.movie.repository.PopularMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO with OnClick add movie to favoriteDB

@HiltViewModel
class HomeMovieViewModel @Inject constructor(
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
                                status = PopularMovieListStateStatus.SUCCESS
                            )
                        }
                        is ApiStatus.Error -> {
                            _popularMovieListState.value = popularMovieListState.value.copy(
                                movieList = emptyList(),
                                errorMessage = apiStatus.message,
                                isLoading = false,
                                status = PopularMovieListStateStatus.ERROR
                            )
                        }
                        is ApiStatus.Loading -> {
                            _popularMovieListState.value = popularMovieListState.value.copy(
                                movieList = emptyList(),
                                errorMessage = null,
                                isLoading = true,
                                status = PopularMovieListStateStatus.LOADING
                            )
                        }
                    }
                }
        }
    }
}