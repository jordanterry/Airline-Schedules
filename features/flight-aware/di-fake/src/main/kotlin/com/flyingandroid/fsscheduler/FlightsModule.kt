package com.flyingandroid.fsscheduler

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [FlightsModule.Bindings::class]
)
object FlightsModule {
    @Module
    interface Bindings {
        @Binds
        @Singleton
        fun bindsFlights(flightsImpl: FakeFlightsImpl): Flights
    }
}