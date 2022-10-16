package com.app.data.remote_data_source.data_source_impl.base

sealed class Result<out T> {
    data class Success<T>(val result: T) : Result<T>()
    data class Error(val cause: Throwable) : Result<Nothing>()
    data class Loading(val isProgressBarVisible: Boolean) : Result<Nothing>()
}