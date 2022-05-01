package com.flyingandroid.fsscheduler

import com.squareup.moshi.JsonAdapter

interface RequestMaker {
    suspend fun <T : Any> get(url: String, adapter: JsonAdapter<T>): T

    interface Builder {
        fun addInterceptor(networkInterceptor: RequestInterceptor): Builder
        fun build(): RequestMaker
    }
}