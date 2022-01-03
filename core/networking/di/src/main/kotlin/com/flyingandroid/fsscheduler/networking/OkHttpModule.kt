package com.flyingandroid.fsscheduler.networking

import com.flyingandroid.fsscheduler.OkHttpBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient

@Module
object OkHttpModule {
    @Provides
    fun providesOkHttpModule(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
        return OkHttpBuilder.build(interceptors)
    }
}