package com.flyingandroid.fsscheduler.schema

data class AirlineSchedule(
    val airline: Airline,
    val flights: Set<Flight>
)
