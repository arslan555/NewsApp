package com.arslan.network.retrofit

import com.arslan.network.request.BaseRequest
import com.arslan.network.Constants
import com.arslan.network.RequestExecutor
import com.arslan.network.model.*
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException

import retrofit2.Response
import timber.log.Timber
import java.net.SocketTimeoutException
import javax.inject.Inject

class RetrofitRequestExecutor @Inject constructor(private val apiInterface: ApiInterface) :
    RequestExecutor {

    override suspend fun <T : Any> execute(request: BaseRequest): NetworkResult<T> {
        return try {
            val response = getApiResponse(request, apiInterface)
            if (response.isSuccessful) {
                val data = Gson().fromJson<T>(response.body(), request.responseType)
                ApiSuccess(data)
            } else {
                ApiError(response.code(), response.errorBody().toString())
            }
        } catch (e: JsonSyntaxException) {
            ApiError(10002, e.message)
        } catch (e: JsonParseException) {
            ApiError(10003, e.message)
        } catch (e: HttpException) {
            ApiError(e.code(), e.message)
        } catch (e: SocketTimeoutException) {
            Timber.e("SocketTimeOut Exception ${e.message} for request ${request.endPoint()}")
            ApiError(10001, e.message)
        } catch (e: Throwable) {
            ApiException(e)
        }
    }


    private suspend fun getApiResponse(
        request: BaseRequest, apiInterface: ApiInterface
    ): Response<String> = when (request.requestMethod()) {
        Constants.RequestMethod.GET -> apiInterface.sendGetRequest(
            endPoint = request.endPoint(),
            headerMap = request.requestHeaders,
            queryMap = request.queryParams
        )
        else -> throw IllegalStateException(
            "Request method ${request.requestMethod()} not found. " + "Kindly provided GET method to proceed"
        )
    }


}