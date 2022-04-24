package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.network.AeroApiAuthInterceptor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import okhttp3.Interceptor

@Module
interface FlightAwareInterceptorsModule {
    @IntoSet
    @Binds
    fun bindsAeroApiAuthInterceptor(AaeroApiAuthInterceptor: AeroApiAuthInterceptor): Interceptor
}