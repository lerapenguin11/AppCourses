package com.example.data.utils

import com.example.domain.utils.ServerResult
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T, R> handleApi(
    apiCall: suspend () -> Response<T>,
    mapper: (T) -> R,
): ServerResult<R> {
    return try {
        val response = apiCall()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            ServerResult.Success(mapper(body))
        } else {
            ServerResult.Error(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        ServerResult.Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        ServerResult.Exception(e)
    }
}