package com.flyingandroid.fsscheduler.schema

data class ScheduledFlight(
    val flightAwareId: String
)

data class FlightSchedule(
    val flights: List<ScheduledFlight>
)