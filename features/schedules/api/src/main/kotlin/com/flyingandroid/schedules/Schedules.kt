package com.flyingandroid.schedules

interface Schedules {
    suspend fun airline(icao: String): Schedule
}