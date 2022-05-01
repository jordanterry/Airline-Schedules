package com.flyingandroid.schedules

import com.flyingandroid.fsscheduler.schema.Airline
import com.flyingandroid.fsscheduler.schema.Airport

data class Schedule(
    val airline: Airline,
    val flightSchedule: List<Flight>,
)

data class Flight(
    val departure: Airport,
    val destination: Airport,
)