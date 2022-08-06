package com.arslan.network.retrofit

import com.arslan.network.NetworkResponse
import com.arslan.network.model.BaseRequest
import com.arslan.network.Constants
import com.arslan.network.RequestExecutor
import com.arslan.network.model.ServerResponseModel
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import retrofit2.Response
import timber.log.Timber
import java.net.SocketTimeoutException
import javax.inject.Inject

class RetrofitRequestExecutor @Inject constructor(private val apiInterface: ApiInterface) : RequestExecutor {

    override suspend fun execute(request: BaseRequest, networkResponse: (NetworkResponse) -> Unit) {
        Timber.d("Endpoint ${request.endPoint()}")
        Timber.d("Headers ${request.requestHeaders}")
        Timber.d("Body ${request.postBody()}")
        Timber.d("QueryParam ${request.queryParams}")
        networkResponse.invoke(NetworkResponse.Loading)
        try {
            val response = getApiResponse(request, apiInterface)
            if (response.isSuccessful) {
                val successResponse = getResponseModel(response.body(), response.code())
                networkResponse.invoke(
                    NetworkResponse.Success(
                        successResponse.model,
                        successResponse.status
                    )
                )
            } else {
                val failureResponse =
                    getResponseModel(response.errorBody()?.string(), response.code())
                networkResponse.invoke(
                    NetworkResponse.Failure(
                        failureResponse.model,
                        failureResponse.status
                    )
                )
            }
        } catch (e: SocketTimeoutException) {
            Timber.e("SocketTimeOut Exception ${e.message} for request ${request.endPoint()}")
            val failureResponse = getResponseModel("", Constants.NetworkCode.Error.REQUEST_TIME_OUT_408)
            networkResponse.invoke(
                NetworkResponse.Failure(
                    failureResponse.model,
                    failureResponse.status
                )
            )
        }

    }


    private suspend fun getApiResponse(
        request: BaseRequest,
        apiInterface: ApiInterface
    ): Response<String> = when (request.requestMethod()) {
        Constants.RequestMethod.GET ->
            apiInterface.sendGetRequest(
                endPoint = request.endPoint(),
                headerMap = request.requestHeaders,
                queryMap = request.queryParams
            )
        else -> throw IllegalStateException(
            "Request method ${request.requestMethod()} not found. " +
                    "Kindly found, Kindly provided GET method to proceed"
        )
    }

    private fun getResponseModel(response: String?, code: Int): ServerResponseModel {
        var data = ServerResponseModel()
        try {
            data = Gson().fromJson(response, ServerResponseModel::class.java)
            if (null == data.model) {
                val element = Gson().fromJson(response, JsonElement::class.java)
                if (element != null) {
                    data.model = element
                }
            }
            data.status = code
        } catch (exception: JsonParseException) {
            Timber.e("Json Parse Exception for response $response")
        }
        return data
    }

}