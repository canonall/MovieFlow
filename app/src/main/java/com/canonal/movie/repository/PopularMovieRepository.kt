package com.canonal.movie.repository

import com.canonal.movie.data.remote.MovieApi
import com.canonal.movie.data.remote.response.PopularMovieResponse
import kotlinx.coroutines.flow.Flow

class PopularMovieRepository(
    private val movieApi: MovieApi
) {
    fun getPopularMovies(): Flow<PopularMovieResponse> = movieApi.getPopularMovies()
}