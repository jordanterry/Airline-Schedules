package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.Airline
import javax.inject.Inject

class AirlinesImpl @Inject constructor(
    private val flightAwareService: FlightAwareService,
    private val billing: Billing
) : Airlines {
    override suspend fun byIcao(icao: String): Airline {
        billing.record(
            BillableAction(
                "operators/$icao",
                0.100,
                "Request for operator: $icao"
            )
        )

        return flightAwareService.getOperatorByIcao(icao)
    }
}