package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.FlightSchedule
import com.flyingandroid.fsscheduler.schema.ScheduledFlight
import com.squareup.moshi.FromJson
import javax.inject.Inject

class ScheduledFlightsAdapter @Inject constructor() {
    @FromJson
    fun fromScheduledFlightsJson(scheduledFlightsJson: ScheduledFlightsJson): FlightSchedule {
        return FlightSchedule(
            flights = scheduledFlightsJson.scheduled.map { ScheduledFlight(it.fa_flight_id) }
        )
    }
}