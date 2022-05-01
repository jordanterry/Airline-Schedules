package com.flyingandroid.schedules

import com.flyingandroid.fsscheduler.Airlines
import com.flyingandroid.fsscheduler.Airports
import com.flyingandroid.fsscheduler.Flights
import com.flyingandroid.fsscheduler.schema.FlightSchedule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ScheduleImpl(
    private val airlines: Airlines,
    private val flights: Flights,
    private val airports: Airports,
) : Schedules {
    override suspend fun airline(icao: String): Schedule {
        val airline = airlines.byIcao(icao)
        val schedule = flights.scheduled(icao)
        return Schedule(
            airline = airline,
            flightSchedule = hydrateScheduledFlights(schedule),
        )
    }

    private suspend fun hydrateScheduledFlights(flightSchedule: FlightSchedule): List<Flight> =
        withContext(Dispatchers.IO) {
            flightSchedule.flights.map { scheduledFlight ->
                val departure = airports.byIcao(scheduledFlight.departure.icao)
                delay(750)
                val destination = airports.byIcao(scheduledFlight.destination.icao)
                Flight(
                    departure = departure,
                    destination = destination,
                )
            }
        }
}