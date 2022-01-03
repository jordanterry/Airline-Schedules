package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.networking.MoshiAdapter
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module(
    includes = [AirportsModule.Bindings::class]
)
object AirportsModule {
    @Module
    interface Bindings {
        @MoshiAdapter
        @Binds
        @IntoSet
        fun bindsAirportAdapter(airportAdapter: AirportAdapter): Any

        @Binds
        fun bindsAirports(airportsImpl: AirportsFakeImpl): Airports
    }
}