package com.arslan.network.retrofit

import com.arslan.network.request.BaseRequest
import com.arslan.network.Constants
import com.arslan.network.RequestExecutor
import com.arslan.network.model.*
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException

import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class RetrofitRequestExecutor @Inject constructor(private val apiInterface: ApiInterface) :
    RequestExecutor {

    override suspend fun <T : Any> execute(request: BaseRequest): NetworkResult<T> {
        return try {
            Timber.d(
                "Request:: " +
                         "Method: ${request.requestMethod()} " +
                         "EndPoint: ${request.endPoint()} " +
                         "QueryParam: ${request.queryParams} " +
                         "Headers: ${request.requestHeaders} " +
                        "Response Type: ${request.responseType}"
            )
            val response = getApiResponse(request, apiInterface)
            if (response.isSuccessful) {
                val data = Gson().fromJson<T>(response.body(), request.responseType)
                ApiSuccess(data)
            } else {
                val type = object : TypeToken<ErrorResponse>() {}.type
                val errorResponse = Gson().fromJson<T>(response.errorBody()!!.charStream(), type)
                ApiError(response.message(), errorResponse)
            }
        } catch (e: JsonSyntaxException) {
            Timber.e("JsonSyntaxException ${e.message} for request ${request.endPoint()}")
            ApiException(e)
        } catch (e: JsonParseException) {
            Timber.e("JsonParseException ${e.message} for request ${request.endPoint()}")
            ApiException(e)
        } catch (e: HttpException) {
            Timber.e("API Exception ${e.message} for request ${request.endPoint()}")
            ApiException(e)
        } catch (e: SocketTimeoutException) {
            Timber.e("SocketTimeOutException ${e.message} for request ${request.endPoint()}")
            ApiException(e)
        } catch (e: IOException) {
            Timber.e("IOException ${e.message} for request ${request.endPoint()}")
            ApiException(e)
        } catch (e: Throwable) {
            Timber.e("General Exception ${e.message} for request ${request.endPoint()}")
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