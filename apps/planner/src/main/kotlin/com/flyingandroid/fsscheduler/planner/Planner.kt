package com.flyingandroid.fsscheduler.planner

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.flyingandroid.fsscheduler.Airlines
import com.flyingandroid.fsscheduler.Airports
import com.flyingandroid.fsscheduler.DaggerFlightAwareComponent
import com.flyingandroid.fsscheduler.Flights
import com.flyingandroid.fsscheduler.billing.DaggerBillingComponent
import com.flyingandroid.fsscheduler.networking.DaggerNetworkingComponent
import com.flyingandroid.fsscheduler.schema.Airline
import com.flyingandroid.fsscheduler.schema.Airport
import com.flyingandroid.fsscheduler.schema.FlightSchedule
import com.jakewharton.mosaic.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import javax.inject.Inject

class Planner @Inject constructor(
    private val airports: Airports,
    private val airlines: Airlines,
    private val flights: Flights,
) {

    fun plan() = runMosaic {
        var airport: Airport? by mutableStateOf(null)
        var airline: Airline? by mutableStateOf(null)
        var schedule: FlightSchedule? by mutableStateOf(null)
        setContent {
            Column {
                if (airport == null) {
                    LoadingRow("Airport")
                } else {
                    LoadedRow("Airport", airport!!.name)
                }
                if (airline == null) {
                    LoadingRow("Airline")
                } else {
                    LoadedRow("Airline", airline!!.name)
                }

                Column {
                    Row {
                        Text("Loading schedule..", background = if (schedule == null) Color.Red else Color.Green)
                    }
                    schedule?.flights?.forEach { flight ->
                        KeyValueRow("Flight ID", flight.flightAwareId)
                    }
                }
            }
        }
        coroutineScope {
            airport = airports.byCode("EGKK")
        }
        coroutineScope {
            airline = airlines.byIcao("WUK")
        }
        coroutineScope {
            schedule = flights.scheduled("WUK")
        }
        delay(6_000)
    }

    @Composable
    fun LoadingRow(title: String) {
        Row {
            Text("Loading $title", background = Color.Red)
        }
    }

    @Composable
    fun LoadedRow(title: String, data: String) {
        Row {
            Text(title, background = Color.Green)
            Text(" ")
            Text(data)
        }
    }

    @Composable
    fun KeyValueRow(key: String, value: String) {
        Row {
            Text("$key: ")
            Text(value)
        }
    }


}

fun main() {

    val billingComponent = DaggerBillingComponent.factory().create()
    val networkingComponent = DaggerNetworkingComponent.factory().create()
    val flightAwareComponent = DaggerFlightAwareComponent.factory().create(networkingComponent, billingComponent)
    val planner = DaggerPlannerComponent.factory().create(flightAwareComponent).planner()
    planner.plan()

}