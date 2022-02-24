package com.canonal.movie.repository

import com.canonal.movie.data.remote.ApiStatus
import com.canonal.movie.data.remote.MovieDataSource
import com.canonal.movie.data.remote.response.PopularMovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource
) : PopularMovieRepository {

    override val popularMovieResponse: Flow<ApiStatus<PopularMovieResponse>> = flow {
        emit(ApiStatus.Loading())
        try {
            emit(ApiStatus.Success(movieDataSource.getPopularMovieResponse()))
        } catch (e: Exception) {
            emit(ApiStatus.Error("Something went wrong..."))
        }
    }
}