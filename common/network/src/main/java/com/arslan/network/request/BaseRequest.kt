package com.arslan.network.request

import org.json.JSONObject
import java.lang.reflect.Type

abstract class BaseRequest {
    abstract fun endPoint(): String
    abstract fun requestMethod(): String
    abstract fun postBody(): JSONObject
    abstract val responseType: Type?

    open val queryParams: MutableMap<String, String?>? by lazy { mutableMapOf() }
    open val fieldMaps: MutableMap<String, String?>? by lazy { mutableMapOf() }
    open val requestHeaders: MutableMap<String,String?>? by lazy { mutableMapOf() }
}