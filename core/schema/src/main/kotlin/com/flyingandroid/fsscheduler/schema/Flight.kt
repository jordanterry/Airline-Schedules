package com.flyingandroid.fsscheduler.schema

data class Flight(
    val ident: String,
    val operator: Airline,
    val flightNumber: String,
    val registration: String,
    val origin: Destination,
    val destination: Destination,
    val aircraft: Aircraft
)
