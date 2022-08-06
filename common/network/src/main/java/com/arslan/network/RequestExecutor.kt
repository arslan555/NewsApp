package com.arslan.network

import com.arslan.network.model.NetworkResponse
import com.arslan.network.request.BaseRequest

interface RequestExecutor {
    suspend fun execute(request: BaseRequest, response: (NetworkResponse) -> Unit) {

    }
}