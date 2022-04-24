package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airport
import com.squareup.moshi.FromJson
import javax.inject.Inject

class AirportAdapter @Inject constructor() {
    @FromJson
    fun fromJson(airportJson: AirportJson): Airport {
        return Airport(
            name = airportJson.name,
            icao = airportJson.airport_code,
            latitude = airportJson.latitude,
            longitude = airportJson.longitude,
            elevation = airportJson.elevation.toDouble(),
            city = airportJson.city,
            country = airportJson.country_code,
            timezone = airportJson.timezone,
        )
    }
}