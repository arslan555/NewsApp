package com.arslan.nytimesnewsapp

import com.arslan.network.RequestExecutor
import com.arslan.network.model.NetworkResult
import com.arslan.network.request.RequestBuilder

import com.google.gson.reflect.TypeToken


import javax.inject.Inject

class NewsRepo @Inject constructor(private val requestExecutor: RequestExecutor) {
    val request  = RequestBuilder.createBasicGetRequest("/users",
        object: TypeToken<UserResponse?>() {}.type)

    suspend operator fun invoke(): NetworkResult<UserResponse> = requestExecutor.execute(request)

}