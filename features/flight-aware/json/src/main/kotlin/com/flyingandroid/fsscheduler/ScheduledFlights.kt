package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.FlightSchedule
import com.flyingandroid.fsscheduler.schema.ScheduledFlight
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScheduledFlightsJson(
    val num_pages: Int,
    val scheduled: List<ScheduledFlightJson>
)

@JsonClass(generateAdapter = true)
data class ScheduledFlightJson(
    val ident: String,
    val fa_flight_id: String,
    val origin: OriginJson,
    val destination: OriginJson? = null,
)

fun ScheduledFlightJson.toModel(): ScheduledFlight? {
    return ScheduledFlight(
        flightAwareId = fa_flight_id,
        departure = origin.toModel(),
        destination = destination?.toModel() ?: return null,
    )
}

fun ScheduledFlightsJson.toModel(): FlightSchedule {
    return FlightSchedule(
        flights = scheduled.mapNotNull { it.toModel() }
    )
}