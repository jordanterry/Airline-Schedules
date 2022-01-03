package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airline

interface Airlines {
    suspend fun byIcao(icao: String): Airline
}
