package com.flyingandroid.fsscheduler

import okhttp3.Interceptor
import okhttp3.Response

class CompositeInterceptor(
    private val networkInterceptors: Set<RequestInterceptor>
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        networkInterceptors.map { networkInterceptor ->
            networkInterceptor.intercept(
                NetworkRequest(
                    url = request.url.toString(),
                    headers = request.headers.toMap()
                )
            )
        }.fold(mapOf<String, String>()) { acc, networkRequest ->
            acc + networkRequest.headers
        }.forEach { header ->
            requestBuilder.addHeader(header.key, header.value)
        }
        return chain.proceed(requestBuilder.build())
    }
}