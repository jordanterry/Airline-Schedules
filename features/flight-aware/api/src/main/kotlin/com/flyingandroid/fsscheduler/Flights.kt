package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.FlightSchedule

interface Flights {
    suspend fun scheduled(icao: String): FlightSchedule
}
