package com.arslan.network

internal object Constants {
    internal const val END_POINT = "end_point"

    internal object QueryParams {
        internal const val API_KEY = "apiKey"
    }

    internal object RequestMethod {
        const val GET = "GET"
    }

    /*
    * Common network codes for Success  & Error responses
    *
    * */
    internal object NetworkCode {

        object Success {
            const val OK_200 = 200
            const val CREATED_201 = 201
            const val NO_CONTENT_204 = 204
        }

        object Error {
            const val BAD_REQUEST_400 = 400
            const val UNAUTHORIZED_401 = 401
            const val NOT_FOUND_404 = 404
            const val REQUEST_TIME_OUT_408 = 408
            const val INTERNAL_SERVER_ERROR_500 = 500
        }
    }
}