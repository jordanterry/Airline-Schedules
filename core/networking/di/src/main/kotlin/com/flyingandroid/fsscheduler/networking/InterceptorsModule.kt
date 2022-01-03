package com.flyingandroid.fsscheduler.networking

import dagger.Module
import dagger.multibindings.Multibinds
import okhttp3.Interceptor

@Module
interface InterceptorsModule {
    @Multibinds
    fun multiBindsInterceptors(): Set<@JvmSuppressWildcards Interceptor>
}