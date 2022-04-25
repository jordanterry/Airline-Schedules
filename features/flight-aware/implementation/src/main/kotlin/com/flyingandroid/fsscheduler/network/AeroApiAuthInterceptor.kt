package com.flyingandroid.fsscheduler.network

import com.flyingandroid.fsscheduler.NetworkInterceptor
import com.flyingandroid.fsscheduler.NetworkRequest
import javax.inject.Inject

class AeroApiAuthNetworkInterceptor @Inject constructor(): NetworkInterceptor {
    override fun intercept(networkRequest: NetworkRequest): NetworkRequest {
        return networkRequest.copy(headers = networkRequest.headers + ("x-api-key" to Config.API_KEY))
    }
}