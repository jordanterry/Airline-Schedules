package com.flyingandroid.fsscheduler

interface NetworkInterceptor {
    fun intercept(networkRequest: NetworkRequest): NetworkRequest
}


data class NetworkRequest(
    val url: String,
    val headers: Map<String, String> = emptyMap()
)