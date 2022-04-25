package com.flyingandroid.fsscheduler

import okhttp3.Interceptor
import okhttp3.OkHttpClient

object OkHttpBuilder {
    fun build(compositeInterceptor: CompositeInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(compositeInterceptor)
        }.build()
    }
}