package com.flyingandroid.fsscheduler

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [AirportsModule.Bindings::class]
)
object AirportsModule {
    @Module
    interface Bindings {
        @Binds
        @Singleton
        fun bindsAirports(airportsImpl: AirportsFakeImpl): Airports
    }
}