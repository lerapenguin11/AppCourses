package com.example.domain.utils

suspend fun <T : Any> ServerResult<T>.onSuccess(
    executable: suspend (T) -> Unit,
): ServerResult<T> = apply {
    if (this is ServerResult.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> ServerResult<T>.onError(
    executable: suspend (code: Int, message: String) -> Unit,
): ServerResult<T> = apply {
    if (this is ServerResult.Error<T>) {
        executable.invoke(code, message ?: "")
    }
}

suspend fun <T : Any> ServerResult<T>.onException(
    executable: suspend (e: Throwable) -> Unit,
): ServerResult<T> = apply {
    if (this is ServerResult.Exception<T>) {
        executable(e)
    }
}