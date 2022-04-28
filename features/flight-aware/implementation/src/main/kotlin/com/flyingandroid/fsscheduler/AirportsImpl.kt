package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.Airport
import javax.inject.Inject

class AirportsImpl @Inject constructor(
    private val billing: Billing,
    private val requestMaker: RequestMaker,
) : Airports {
    override suspend fun byCode(airportCode: String): Airport {
        billing.record(
            BillableAction(
                "airport/$airportCode",
                0.025,
                "Request for airport: $airportCode"
            )
        )
        return requestMaker.get("$BASE_URL$AIRPORT_INFO_PATH$airportCode", Airport::class.java)
    }

    companion object {
        private const val BASE_URL = "https://aeroapi.flightaware.com/aeroapi/"
        private const val AIRPORT_INFO_PATH = "airports/"
    }
}