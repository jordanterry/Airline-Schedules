package com.flyingandroid.fsscheduler.network

import com.flyingandroid.fsscheduler.NetworkRequest
import com.flyingandroid.fsscheduler.RequestInterceptor
import javax.inject.Inject

class AeroApiAuthNetworkInterceptor @Inject constructor() : RequestInterceptor {
    override fun intercept(networkRequest: NetworkRequest): NetworkRequest {
        return networkRequest.copy(headers = networkRequest.headers + ("x-apikey" to Config.API_KEY))
    }
}