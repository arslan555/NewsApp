package com.arslan.network.retrofit

import com.arslan.network.NetworkResponse
import com.arslan.network.BaseRequest
import com.arslan.network.RequestExecutor

class RetrofitRequestExecutor: RequestExecutor {

    override suspend fun execute(request: BaseRequest, response: (NetworkResponse) -> Unit) {

    }
}