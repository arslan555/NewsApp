package com.arslan.network

import com.arslan.network.model.BaseRequest

interface RequestExecutor {
    suspend fun execute(request: BaseRequest, response: (NetworkResponse) -> Unit) {

    }
}