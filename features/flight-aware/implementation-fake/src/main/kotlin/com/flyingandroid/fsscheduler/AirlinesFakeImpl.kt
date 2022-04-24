package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airline
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import okio.buffer
import okio.source
import java.io.InputStream
import javax.inject.Inject

class AirlinesFakeImpl @Inject constructor(
    private val moshi: Moshi
) : Airlines {
    override suspend fun byIcao(icao: String): Airline {
        val adapter = moshi.adapter(Airline::class.java)
        val jsonReader = JsonReader.of(loadFromResources("operators/$icao.json"))
        return adapter.fromJson(jsonReader)!!
    }
}

