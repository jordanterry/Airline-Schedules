package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airport
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import javax.inject.Inject

class AirportsFakeImpl @Inject constructor(
    private val moshi: Moshi
) : Airports {
    override suspend fun byCode(airportCode: String): Airport {
        val adapter = moshi.adapter(Airport::class.java)
        val jsonReader = JsonReader.of(loadFromResources("airports/$airportCode.json"))
        return adapter.fromJson(jsonReader)!!
    }
}