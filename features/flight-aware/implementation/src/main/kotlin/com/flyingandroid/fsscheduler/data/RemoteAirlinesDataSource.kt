package com.flyingandroid.fsscheduler.data

import com.flyingandroid.fsscheduler.OperatorJsonJsonAdapter
import com.flyingandroid.fsscheduler.RequestMaker
import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.Airline
import com.flyingandroid.fsscheduler.toModel
import com.squareup.moshi.Moshi
import javax.inject.Inject


class RemoteAirlinesDataSource @Inject constructor(
    private val billing: Billing,
    private val requestMaker: RequestMaker,
    private val moshi: Moshi
) : AirlinesDataSource {
    override suspend fun byIcao(icao: String): Airline {
        billing.record(
            BillableAction(
                "operators/$icao",
                0.100,
                "Request for operator: $icao"
            )
        )
        return requestMaker.get("$BASE_URL$AIRLINES_PATH$icao", OperatorJsonJsonAdapter(moshi)).toModel()
    }

    companion object {
        private const val BASE_URL = "https://aeroapi.flightaware.com/aeroapi/"
        private const val AIRLINES_PATH = "operators/"
    }
}

