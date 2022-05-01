package com.flyingandroid.schedules

import com.flyingandroid.fsscheduler.Airlines
import com.flyingandroid.fsscheduler.Airports
import com.flyingandroid.fsscheduler.Flights
import dagger.Module
import dagger.Provides

@Module
object SchedulesModule {
    @Provides
    fun providesSchedules(airlines: Airlines, flights: Flights, airports: Airports): Schedules {
        return ScheduleImpl(
            airlines = airlines,
            flights = flights,
            airports = airports,
        )
    }
}