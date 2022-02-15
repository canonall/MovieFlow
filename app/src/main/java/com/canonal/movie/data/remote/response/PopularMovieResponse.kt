package com.canonal.movie.data.remote.response

import com.canonal.movie.model.Movie
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("results")
    val movie: List<Movie>,
)