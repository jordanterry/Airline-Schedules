package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.FlightSchedule
import javax.inject.Inject

class FlightsImpl @Inject constructor(
    private val billing: Billing,
    private val requestMaker: RequestMaker,
) : Flights {
    override suspend fun scheduled(icao: String): FlightSchedule {
        billing.record(
            BillableAction(
                "/operators/$icao/flights/scheduled",
                0.030,
                "Scheduled flights for $icao"
            )
        )
        val replaced = AIRLINES_PATH.replace("{icao}", icao)
        return requestMaker.get("$BASE_URL$replaced", FlightSchedule::class.java)
    }

    companion object {
        private const val BASE_URL = "https://aeroapi.flightaware.com/aeroapi/"
        private const val AIRLINES_PATH = "operators/{icao}/flights/scheduled"
    }
}