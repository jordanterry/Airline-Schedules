package com.flyingandroid.fsscheduler.schema

data class ScheduledFlight(
    val flightAwareId: String,
    val departure: Origin,
    val destination: Origin,
)

data class FlightSchedule(
    val flights: List<ScheduledFlight>
)