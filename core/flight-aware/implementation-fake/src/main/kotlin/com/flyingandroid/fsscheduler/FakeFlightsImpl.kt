package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.FlightSchedule
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import javax.inject.Inject

class FakeFlightsImpl @Inject constructor(
    private val moshi: Moshi
) : Flights {
    override suspend fun scheduled(icao: String): FlightSchedule {
        val adapter = moshi.adapter(FlightSchedule::class.java)
        val jsonReader = JsonReader.of(loadFromResources("operators/$icao/flights/scheduled.json"))
        return adapter.fromJson(jsonReader)!!
    }
}