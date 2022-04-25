package com.flyingandroid.fsscheduler.networking

import com.flyingandroid.fsscheduler.NetworkInterceptor
import dagger.Module
import dagger.multibindings.Multibinds
import okhttp3.Interceptor

@Module
interface InterceptorsModule {
    @Multibinds
    fun multiBindsInterceptors(): Set<@JvmSuppressWildcards NetworkInterceptor>
}