package com.arslan.network.model

import com.google.gson.JsonElement

sealed class NetworkResponse {
    data class Success(val response: JsonElement?, val statusCode: Int): NetworkResponse()
    data class Failure(val response: JsonElement?, val statusCode: Int): NetworkResponse()
    object Loading: NetworkResponse()
}