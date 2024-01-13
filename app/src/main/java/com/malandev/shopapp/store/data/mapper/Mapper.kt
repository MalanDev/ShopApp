package com.malandev.shopapp.store.data.mapper

import com.malandev.shopapp.store.domain.model.ApiError
import com.malandev.shopapp.store.domain.model.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError():NetworkError{
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException-> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return  NetworkError(error = error,
        t = this)
}