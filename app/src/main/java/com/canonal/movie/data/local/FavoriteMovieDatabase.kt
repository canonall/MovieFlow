package com.canonal.movie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.canonal.movie.data.local.entity.FavoriteMovie

@Database(
    entities = [FavoriteMovie::class],
    version = 1,
    exportSchema = false
)
abstract class FavoriteMovieDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao(): FavoriteMovieDao
}