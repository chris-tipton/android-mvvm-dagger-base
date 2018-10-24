package com.tiptop.androidbase.data.common

sealed class Result<out T> {
    fun <T> copyWithNewValue(newValue: T): Result<T> {
        return when (this) {
            is Success -> Success(newValue)
            is Failure -> Failure(nextError)
        }
    }

    fun <R> map(objectMapper: (T?) -> R?): Result<R> {
        return when (this) {
            is Success -> Success(objectMapper(value))
            is Failure -> Failure(nextError)
        }
    }
}

data class Success<out T>(val value: T? = null) : Result<T>()

data class Failure<out T>(val nextError: NextError) : Result<T>()