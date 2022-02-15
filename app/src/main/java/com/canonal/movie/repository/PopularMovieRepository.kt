package com.canonal.movie.repository

import com.canonal.movie.data.remote.MovieApi
import kotlinx.coroutines.flow.flow

class PopularMovieRepository(
    private val movieApi: MovieApi
) {
    val popularMovieResponse = flow {
        emit(movieApi.getPopularMovieResponse())
    }
}