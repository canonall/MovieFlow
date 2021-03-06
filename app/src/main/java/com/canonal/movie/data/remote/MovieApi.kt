package com.canonal.movie.data.remote

import com.canonal.movie.BuildConfig
import com.canonal.movie.data.remote.response.PopularMovieResponse
import com.canonal.movie.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("{version}/movie/popular")
    suspend fun getPopularMovieResponse(
        @Path("version") version: Int = 3,
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = BuildConfig.URL_LANGUAGE,
        @Query("page") page: Int = 1
    ): PopularMovieResponse
}