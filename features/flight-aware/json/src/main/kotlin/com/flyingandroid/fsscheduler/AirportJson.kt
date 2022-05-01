package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airport
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AirportJson(
    val airport_code: String,
    val alternate_ident: String,
    val name: String,
    val elevation: Int,
    val city: String,
    val longitude: Double,
    val latitude: Double,
    val timezone: String,
    val country_code: String,
    val wiki_url: String,
    val airport_flights_url: String
)

fun AirportJson.toModel(): Airport {
    return Airport(
        name = name,
        icao = airport_code,
        latitude = latitude,
        longitude = longitude,
        elevation = elevation.toDouble(),
        city = city,
        country = country_code,
        timezone = timezone
    )
}