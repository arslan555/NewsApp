package com.arslan.network.request

import com.arslan.network.Constants
import java.lang.reflect.Type

object RequestBuilder {
    fun createBasicGetRequest(
        path: String,
        token: Type,
        headers: Map<String, String?> = mutableMapOf()
    ): ApiRequest {
        val apiRequest = getBaseRequest(path, token)
        apiRequest.setRequestMethod(Constants.RequestMethod.GET)
        apiRequest.requestHeaders?.putAll(headers)
        return apiRequest
    }


    private fun getBaseRequest(path: String, token: Type): ApiRequest {
        return ApiRequest().apply {
            setPath(path)
            setTypeToken(token)
        }
    }

}