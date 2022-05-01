package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.data.FlightsDataSource
import com.flyingandroid.fsscheduler.schema.FlightSchedule

class FlightsImpl(
    private val remoteFlightsDataSource: FlightsDataSource
) : Flights {
    override suspend fun scheduled(icao: String): FlightSchedule {
        return remoteFlightsDataSource.byIcao(icao)
    }
}