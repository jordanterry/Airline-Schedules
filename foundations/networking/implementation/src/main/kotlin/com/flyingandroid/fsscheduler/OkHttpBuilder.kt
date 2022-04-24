package com.flyingandroid.fsscheduler

import okhttp3.Interceptor
import okhttp3.OkHttpClient

object OkHttpBuilder {
    fun build(interceptors: Set<Interceptor>): OkHttpClient {
        return OkHttpClient.Builder().apply {
            interceptors.forEach { interceptor ->
                addInterceptor(interceptor)
            }
        }.build()
    }
}