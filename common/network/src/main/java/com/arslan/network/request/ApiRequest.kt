package com.arslan.network.request

import org.json.JSONException
import org.json.JSONObject
import java.lang.reflect.Type

class ApiRequest : BaseRequest() {
    private var path: String? = null
    private var body: String? = null
    private var requestMethod: String? = null
    override var responseType: Type? = null
        private set

    fun setPath(path: String) {
        this.path = path
    }

    fun setBody(body: String) {
        this.body = body;
    }

    fun setRequestMethod(requestMethod: String) {
        this.requestMethod = requestMethod;
    }

    fun setTypeToken(typeToken: Type) {
        this.responseType = typeToken
    }

    override fun endPoint(): String {
        return path ?: ""
    }

    override fun requestMethod(): String {
        return requestMethod ?: ""
    }

    override fun postBody(): JSONObject {
        try {
            return JSONObject(body ?: "")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return JSONObject()
    }


}