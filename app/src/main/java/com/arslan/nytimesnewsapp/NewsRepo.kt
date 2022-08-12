package com.arslan.nytimesnewsapp

import com.arslan.network.RequestExecutor
import com.arslan.network.model.ApiError
import com.arslan.network.model.ApiException
import com.arslan.network.model.ApiSuccess
import com.arslan.network.model.NetworkResult
import com.arslan.network.request.RequestBuilder

import com.google.gson.reflect.TypeToken
import timber.log.Timber


import javax.inject.Inject

class NewsRepo @Inject constructor(private val requestExecutor: RequestExecutor) {
    val request  = RequestBuilder.createBasicGetRequest("/users",
        object: TypeToken<UserResponse?>() {}.type)

    suspend operator fun invoke() {
        when(val response =  requestExecutor.execute<UserResponse>(request) ) {
            is ApiSuccess -> Timber.d("${response.data}")
            is ApiError -> Timber.d("${response.message}")
            is ApiException -> Timber.d("${response.e.message}")
        }
    }

}