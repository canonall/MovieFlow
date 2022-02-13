package com.canonal.movie.model

import com.google.gson.annotations.SerializedName

data class Results(
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)
