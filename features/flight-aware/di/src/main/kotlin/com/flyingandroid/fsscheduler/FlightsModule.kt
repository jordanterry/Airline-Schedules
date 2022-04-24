package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.networking.MoshiAdapter
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module(
    includes = [FlightAwareServiceModule::class, FlightsModule.Bindings::class]
)
object FlightsModule {
    @Module
    interface Bindings {

        @MoshiAdapter
        @Binds
        @IntoSet
        fun bindsScheduleAdapter(scheduledFlightsAdapter: ScheduledFlightsAdapter): Any

        @Binds
        fun bindsFlights(flightsImpl: FlightsImpl): Flights
    }
}