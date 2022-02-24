package com.canonal.movie.data.remote

import com.canonal.movie.data.remote.response.PopularMovieResponse

interface MovieDataSource {
    suspend fun getPopularMovieResponse(): PopularMovieResponse
}