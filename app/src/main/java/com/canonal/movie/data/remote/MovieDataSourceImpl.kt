package com.canonal.movie.data.remote

import com.canonal.movie.data.remote.response.PopularMovieResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieDataSource {
    override suspend fun getPopularMovieResponse(): PopularMovieResponse =
        movieApi.getPopularMovieResponse()
}