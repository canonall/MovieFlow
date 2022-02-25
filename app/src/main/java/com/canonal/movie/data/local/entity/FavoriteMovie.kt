package com.canonal.movie.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movie_table")
data class FavoriteMovie(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "Undefined",
    val posterUrl: String = "",
    val releaseDate: String = "Undefined",
    val voteAverage: Double = 0.0,
    val dateOfFavorite: String = "Undefined"
)