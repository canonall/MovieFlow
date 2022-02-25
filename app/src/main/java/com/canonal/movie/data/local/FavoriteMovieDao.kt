package com.canonal.movie.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.canonal.movie.data.local.entity.FavoriteMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {

    @Insert
    suspend fun insertFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Delete
    suspend fun deleteFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Query("SELECT * FROM favorite_movie_table")
    fun getFavoriteMovieList(): Flow<List<FavoriteMovie>>

    @Query("DELETE FROM favorite_movie_table")
    suspend fun deleteAllFavoriteMovie()
}