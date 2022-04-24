package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.BillableAction
import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.schema.FlightSchedule
import javax.inject.Inject

class FlightsImpl @Inject constructor(
    private val flightAwareService: FlightAwareService,
    private val billing: Billing,
) : Flights {
    override suspend fun scheduled(icao: String): FlightSchedule {
        billing.record(
            BillableAction(
                "/operators/$icao/flights/scheduled",
                0.030,
                "Scheduled flights for $icao"
            )
        )
        return flightAwareService.getScheduleFlightsByIcao(icao)
    }
}