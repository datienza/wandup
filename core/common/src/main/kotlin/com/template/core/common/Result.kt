package com.template.core.common

sealed class Result<out T, out E> {
    data class Success<T>(val value: T) : Result<T, Nothing>()
    data class Failure<E>(val error: E) : Result<Nothing, E>()

    inline fun <R> fold(
        onSuccess: (T) -> R,
        onFailure: (E) -> R,
    ): R = when (this) {
        is Success -> onSuccess(value)
        is Failure -> onFailure(error)
    }

    inline fun <R> map(transform: (T) -> R): Result<R, E> = when (this) {
        is Success -> Success(transform(value))
        is Failure -> this
    }

    fun getOrNull(): T? = when (this) {
        is Success -> value
        is Failure -> null
    }
}
