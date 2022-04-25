package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.network.AeroApiAuthNetworkInterceptor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface FlightAwareInterceptorsModule {
    @IntoSet
    @Binds
    fun bindsAeroApiAuthInterceptor(aeroApiAuthInterceptor: AeroApiAuthNetworkInterceptor): NetworkInterceptor
}