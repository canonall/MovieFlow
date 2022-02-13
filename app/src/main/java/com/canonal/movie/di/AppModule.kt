package com.canonal.movie.di

import com.canonal.movie.data.remote.MovieApi
import com.canonal.movie.data.remote.RetrofitInstance
import com.canonal.movie.repository.PopularMovieRepository

object AppModule {

    fun getPopularMovieRepository(): PopularMovieRepository {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
        val movieApi = retrofitInstance.create(MovieApi::class.java)
        return PopularMovieRepository(movieApi)
    }
}