package com.canonal.movie.ui.movieHome

import com.canonal.movie.model.Movie

data class PopularMovieListState(
    val movieList: List<Movie> = emptyList(),
    val errorMessage: String? = "",
    val isLoading: Boolean = true,
    val status: PopularMovieListStateStatus = PopularMovieListStateStatus.LOADING
)

enum class PopularMovieListStateStatus {
    SUCCESS, ERROR, LOADING
}
