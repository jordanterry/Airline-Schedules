package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.Airline
import javax.inject.Inject

class AirlinesImpl @Inject constructor(
    private val billing: Billing,
    private val requestMaker: RequestMaker,
) : Airlines {
    override suspend fun byIcao(icao: String): Airline {
        billing.record(
            BillableAction(
                "operators/$icao",
                0.100,
                "Request for operator: $icao"
            )
        )
        return requestMaker.get("$BASE_URL$AIRLINES_PATH$icao", Airline::class.java)
    }

    companion object {
        private const val BASE_URL = "https://aeroapi.flightaware.com/aeroapi/"
        private const val AIRLINES_PATH = "operators/"
    }
}