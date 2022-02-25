package com.canonal.movie.di

import android.content.Context
import androidx.room.Room
import com.canonal.movie.data.local.FavoriteMovieDao
import com.canonal.movie.data.local.FavoriteMovieDatabase
import com.canonal.movie.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideFavoriteMovieDao(database: FavoriteMovieDatabase): FavoriteMovieDao =
        database.favoriteMovieDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FavoriteMovieDatabase =
        Room.databaseBuilder(
            context,
            FavoriteMovieDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
}