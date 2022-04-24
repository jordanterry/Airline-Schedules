package com.flyingandroid.fsscheduler

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