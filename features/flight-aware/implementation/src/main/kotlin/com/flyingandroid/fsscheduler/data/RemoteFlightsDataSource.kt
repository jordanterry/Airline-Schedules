package com.flyingandroid.fsscheduler.data

import com.flyingandroid.fsscheduler.RequestMaker
import com.flyingandroid.fsscheduler.ScheduledFlightsJsonJsonAdapter
import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.FlightSchedule
import com.flyingandroid.fsscheduler.toModel
import com.squareup.moshi.Moshi

class RemoteFlightsDataSource(
    private val billing: Billing,
    private val requestMaker: RequestMaker,
    private val moshi: Moshi
) : FlightsDataSource {
    override suspend fun byIcao(icao: String): FlightSchedule {
        billing.record(
            BillableAction(
                "/operators/$icao/flights/scheduled",
                0.030,
                "Scheduled flights for $icao"
            )
        )
        val replaced = AIRLINES_PATH.replace("{icao}", icao)
        return requestMaker.get("$BASE_URL$replaced", ScheduledFlightsJsonJsonAdapter(moshi)).toModel()
    }

    companion object {
        private const val BASE_URL = "https://aeroapi.flightaware.com/aeroapi/"
        private const val AIRLINES_PATH = "operators/{icao}/flights/scheduled"
    }
}

