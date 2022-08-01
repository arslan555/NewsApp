package com.arslan.network

import com.google.gson.JsonElement

sealed class NetworkResponse {
    data class Success(val response: JsonElement, val status: Int): NetworkResponse()
    data class Failure(val message: String): NetworkResponse()

    companion object {
        fun <T> success(data: JsonElement,status: Int) = Success(data,status)
        fun <T> failure(message: String) = Failure(message)
    }
}