package com.template.backend.core

abstract class BaseNetworkDataSource {
    protected suspend fun <T> safeApiCall(
        apiCall: suspend () -> T,
    ): Result<T> = try {
        Result.success(apiCall())
    } catch (e: Exception) {
        Result.failure(e)
    }
}
