package com.canonal.movie.repository

import com.canonal.movie.data.remote.MovieApi
import com.canonal.movie.data.remote.response.PopularMovieResponse
import com.canonal.movie.data.remote.ApiStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PopularMovieRepository(
    private val movieApi: MovieApi
) {
    val popularMovieResponse: Flow<ApiStatus<PopularMovieResponse>> = flow {
        emit(ApiStatus.Loading())
        try {
            emit(ApiStatus.Success(movieApi.getPopularMovieResponse()))
        } catch (e: Exception) {
            emit(ApiStatus.Error("Something went wrong..."))
        }
    }
}