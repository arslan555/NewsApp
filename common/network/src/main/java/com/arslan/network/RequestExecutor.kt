package com.arslan.network

import com.arslan.network.model.NetworkResult
import com.arslan.network.request.BaseRequest

interface RequestExecutor {
    suspend fun<T: Any> execute(request: BaseRequest): NetworkResult<T>
}