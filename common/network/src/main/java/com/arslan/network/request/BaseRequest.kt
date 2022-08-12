package com.arslan.network.request

import java.lang.reflect.Type

abstract class BaseRequest {
    abstract fun endPoint(): String
    abstract fun requestMethod(): String
    abstract val responseType: Type?

    open val queryParams: MutableMap<String, String?>? by lazy { mutableMapOf() }
    open val requestHeaders: MutableMap<String,String?>? by lazy { mutableMapOf() }
}