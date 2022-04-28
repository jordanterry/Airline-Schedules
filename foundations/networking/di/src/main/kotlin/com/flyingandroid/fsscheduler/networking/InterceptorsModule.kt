package com.flyingandroid.fsscheduler.networking

import com.flyingandroid.fsscheduler.CompositeInterceptor
import com.flyingandroid.fsscheduler.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds

@Module(includes = [InterceptorsModule.MultiBindings::class])
object InterceptorsModule {

    @Provides
    fun providesCompositeInterceptor(networkInterceptors: Set<@JvmSuppressWildcards NetworkInterceptor>): CompositeInterceptor {
        return CompositeInterceptor(networkInterceptors = networkInterceptors)
    }

    @Module
    interface MultiBindings {
        @Multibinds
        fun multiBindsInterceptors(): Set<@JvmSuppressWildcards NetworkInterceptor>
    }
}