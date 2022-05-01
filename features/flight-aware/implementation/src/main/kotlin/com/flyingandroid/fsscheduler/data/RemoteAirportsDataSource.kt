package com.flyingandroid.fsscheduler.data

import com.flyingandroid.fsscheduler.AirportJsonJsonAdapter
import com.flyingandroid.fsscheduler.RequestMaker
import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.Airport
import com.flyingandroid.fsscheduler.toModel
import com.squareup.moshi.Moshi
import javax.inject.Inject

class RemoteAirportsDataSource @Inject constructor(
    private val billing: Billing,
    private val requestMaker: RequestMaker,
    private val moshi: Moshi
) : AirportsDataSource {
    override suspend fun byIcao(icao: String): Airport {
        billing.record(
            BillableAction(
                "airport/$icao",
                0.025,
                "Request for airport: $icao"
            )
        )
        return requestMaker.get("$BASE_URL$AIRPORT_INFO_PATH$icao", AirportJsonJsonAdapter(moshi)).toModel()
    }

    companion object {
        private const val BASE_URL = "https://aeroapi.flightaware.com/aeroapi/"
        private const val AIRPORT_INFO_PATH = "airports/"
    }
}

