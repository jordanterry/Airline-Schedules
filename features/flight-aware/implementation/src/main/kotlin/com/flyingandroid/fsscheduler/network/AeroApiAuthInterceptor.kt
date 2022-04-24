package com.flyingandroid.fsscheduler.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AeroApiAuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("x-apikey", Config.API_KEY)
        return chain.proceed(requestBuilder.build())
    }
}