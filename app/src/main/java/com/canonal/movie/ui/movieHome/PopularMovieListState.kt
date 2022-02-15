package com.canonal.movie.ui.movieHome

import com.canonal.movie.model.Movie

data class PopularMovieListState(
    val movieList: List<Movie> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
