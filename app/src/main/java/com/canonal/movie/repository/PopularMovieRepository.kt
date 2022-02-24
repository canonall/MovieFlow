package com.canonal.movie.repository

import com.canonal.movie.data.remote.ApiStatus
import com.canonal.movie.data.remote.response.PopularMovieResponse
import kotlinx.coroutines.flow.Flow

interface PopularMovieRepository {
    val popularMovieResponse: Flow<ApiStatus<PopularMovieResponse>>
}
