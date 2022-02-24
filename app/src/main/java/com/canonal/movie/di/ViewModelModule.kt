package com.canonal.movie.di

import com.canonal.movie.repository.PopularMovieRepository
import com.canonal.movie.repository.PopularMovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @ViewModelScoped
    @Binds
    abstract fun bindPopularMovieRepository(
        popularMovieRepositoryImpl: PopularMovieRepositoryImpl
    ): PopularMovieRepository
}