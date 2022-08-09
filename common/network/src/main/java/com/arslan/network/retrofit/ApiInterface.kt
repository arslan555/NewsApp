package com.arslan.network.retrofit

import com.arslan.network.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET("{$END_POINT}")
    suspend fun sendGetRequest(
        @Path(value = END_POINT, encoded = true) endPoint: String?,
        @HeaderMap headerMap: MutableMap<String, String?>?,
        @QueryMap queryMap: MutableMap<String, String?>?
    ): Response<String>

}