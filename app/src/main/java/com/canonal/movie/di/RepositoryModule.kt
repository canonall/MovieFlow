package com.canonal.movie.di

import com.canonal.movie.data.remote.MovieDataSource
import com.canonal.movie.data.remote.MovieDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieDataSource(movieDataSourceImpl: MovieDataSourceImpl): MovieDataSource
}