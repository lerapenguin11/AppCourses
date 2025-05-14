package com.example.domain.utils

sealed class ServerResult<out T> {
    data class Success<out T>(val data: T) : ServerResult<T>()
    data class Error<T : Any>(val code: Int, val message: String?) : ServerResult<T>()
    data class Exception<T : Any>(val e: Throwable) : ServerResult<T>()
}