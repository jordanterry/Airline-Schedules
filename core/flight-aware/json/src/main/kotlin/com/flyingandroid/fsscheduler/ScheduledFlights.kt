package com.flyingandroid.fsscheduler

data class ScheduledFlightsJson(
    val num_pages: Int,
    val scheduled: List<ScheduledFlightJson>
)

data class ScheduledFlightJson(
    val ident: String,
    val fa_flight_id: String
)
