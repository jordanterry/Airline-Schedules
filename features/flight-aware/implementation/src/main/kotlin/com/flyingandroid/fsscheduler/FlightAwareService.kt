package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airline
import com.flyingandroid.fsscheduler.schema.Airport
import com.flyingandroid.fsscheduler.schema.FlightSchedule
import retrofit2.http.GET
import retrofit2.http.Path

interface FlightAwareService {
    @GET("operators/{icao}")
    suspend fun getOperatorByIcao(@Path("icao") icao: String): Airline

    @GET("operators/{icao}/flights/scheduled")
    suspend fun getScheduleFlightsByIcao(@Path("icao") icao: String): FlightSchedule

    @GET("airports/{airportCode}")
    suspend fun getAirportInfo(@Path("airportCode") airportCode: String): Airport
}