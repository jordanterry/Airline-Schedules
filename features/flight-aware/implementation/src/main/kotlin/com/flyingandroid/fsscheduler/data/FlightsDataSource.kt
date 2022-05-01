package com.flyingandroid.fsscheduler.data

import com.flyingandroid.fsscheduler.schema.FlightSchedule

interface FlightsDataSource {
    suspend fun byIcao(icao: String): FlightSchedule
}