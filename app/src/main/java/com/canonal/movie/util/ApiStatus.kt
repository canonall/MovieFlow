package com.canonal.movie.util

sealed class ApiStatus<out T> {
    class Success<T>(val data: T?) : ApiStatus<T>()
    class Error<T>(val message: String) : ApiStatus<T>()
    class Loading<T> : ApiStatus<T>()
}
