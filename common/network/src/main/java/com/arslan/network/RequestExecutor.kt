package com.arslan.network

import com.arslan.network.model.NetworkResult
import com.arslan.network.request.BaseRequest
import retrofit2.Response

interface RequestExecutor {
    suspend fun<T: Any> execute(request: BaseRequest): NetworkResult<T>
}