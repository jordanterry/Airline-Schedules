package com.flyingandroid.fsscheduler.schema

data class Airline(
    val name: String,
    val icao: String,
    val location: String? = null,
    val country: String? = null,
)
