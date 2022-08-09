package com.arslan.nytimesnewsapp

import com.arslan.network.RequestExecutor
import com.arslan.network.request.RequestBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsRepo @Inject constructor(private val requestExecutor: RequestExecutor) {

    public fun getResponse() {
        GlobalScope.launch {
            val request  = RequestBuilder.createBasicGetRequest("/users",
                object: TypeToken<UserResponse>() {}.type)
            requestExecutor.execute(request) {

            }
        }
    }
}