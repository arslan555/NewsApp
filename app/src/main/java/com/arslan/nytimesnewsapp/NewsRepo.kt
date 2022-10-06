package com.arslan.nytimesnewsapp

import com.arslan.network.RequestExecutor
import com.arslan.network.model.ApiError
import com.arslan.network.model.ApiException
import com.arslan.network.model.ApiSuccess
import com.arslan.network.request.RequestBuilder
import com.arslan.nytimesnewsapp.model.NewsSources

import com.google.gson.reflect.TypeToken
import timber.log.Timber


import javax.inject.Inject

class NewsRepo @Inject constructor(private val requestExecutor: RequestExecutor) {
    private val userRequest  = RequestBuilder.createBasicGetRequest("top-headlines/sources",
        object: TypeToken<NewsSources?>() {}.type)

    suspend operator fun invoke() {
        when(val response =  requestExecutor.execute<NewsSources>(userRequest) ) {
            is ApiSuccess -> Timber.d("${response.data}")
            is ApiError -> Timber.d(response.errorResponse.toString())
            is ApiException -> Timber.e("${response.e.message}")
        }
    }

}