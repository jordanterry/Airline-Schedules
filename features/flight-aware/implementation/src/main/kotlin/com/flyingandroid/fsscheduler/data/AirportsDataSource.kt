package com.flyingandroid.fsscheduler.data

import com.flyingandroid.fsscheduler.schema.Airport

interface AirportsDataSource {
    suspend fun byIcao(icao: String): Airport
}