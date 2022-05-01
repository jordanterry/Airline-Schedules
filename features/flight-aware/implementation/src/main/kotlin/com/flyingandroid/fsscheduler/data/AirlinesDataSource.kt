package com.flyingandroid.fsscheduler.data

import com.flyingandroid.fsscheduler.schema.Airline

interface AirlinesDataSource {
    suspend fun byIcao(icao: String): Airline
}