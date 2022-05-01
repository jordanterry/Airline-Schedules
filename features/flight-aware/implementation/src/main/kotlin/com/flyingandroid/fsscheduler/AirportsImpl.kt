package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.data.AirportsDataSource
import com.flyingandroid.fsscheduler.schema.Airport

class AirportsImpl(
    private val remoteAirportsDataSource: AirportsDataSource
) : Airports {
    override suspend fun byIcao(icao: String): Airport {
        return remoteAirportsDataSource.byIcao(icao)
    }
}