package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airport

interface Airports {
    suspend fun byCode(airportCode: String): Airport
}
