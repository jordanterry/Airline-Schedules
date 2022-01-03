package com.flyingandroid.fsscheduler.schema

data class Airport(
    val name: String,
    val icao: String,
    val latitude: Double,
    val longitude: Double,
    val elevation: Double,
    val city: String,
    val country: String,
    val timezone: String,
)
