package com.arslan.network

interface RequestExecutor {
    suspend fun execute(request: BaseRequest, response: (NetworkResponse) -> Unit) {

    }
}