package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.network.AeroApiAuthNetworkInterceptor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module(
    includes = [FlightAwareInterceptorsModule.Bindings::class]
)
object FlightAwareInterceptorsModule {
    @Module
    interface Bindings {
        @IntoSet
        @Binds
        fun bindsAeroApiAuthInterceptor(aeroApiAuthInterceptor: AeroApiAuthNetworkInterceptor): RequestInterceptor
    }
}