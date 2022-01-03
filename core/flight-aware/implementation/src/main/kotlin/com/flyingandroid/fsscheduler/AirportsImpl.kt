package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.Airport
import javax.inject.Inject

class AirportsImpl @Inject constructor(
    private val flightAwareService: FlightAwareService,
    private val billing: Billing
) : Airports {
    override suspend fun byCode(airportCode: String): Airport {
        billing.record(
            BillableAction(
                "airport/$airportCode",
                0.025,
                "Request for airport: $airportCode"
            )
        )

        return flightAwareService.getAirportInfo(airportCode)
    }
}