package com.flyingandroid.fsscheduler.networking

import com.flyingandroid.fsscheduler.CompositeInterceptor
import com.flyingandroid.fsscheduler.NetworkInterceptor
import com.flyingandroid.fsscheduler.OkHttpBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient

@Module
object OkHttpModule {

    @Provides
    fun compositeInterceptor(interceptors: Set<@JvmSuppressWildcards NetworkInterceptor>): Interceptor {
        return CompositeInterceptor(interceptors)
    }

    @Provides
    fun providesOkHttpModule(compositeInterceptor: CompositeInterceptor): OkHttpClient {
        return OkHttpBuilder.build(compositeInterceptor)
    }
}