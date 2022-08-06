package com.arslan.network.model

import com.google.gson.JsonElement

data class ServerResponseModel(var status: Int = -1, var model: JsonElement? = null)