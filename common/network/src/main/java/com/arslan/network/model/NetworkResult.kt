package com.arslan.network.model


sealed interface NetworkResult<T: Any>
    class ApiSuccess<T: Any>(val data: T) : NetworkResult<T>
    class ApiError<T: Any>(val message: String, val errorResponse: T?) : NetworkResult<T>
    class ApiException<T: Any>(val e: Throwable) : NetworkResult<T>
