package com.flyingandroid.fsscheduler.planner

import com.flyingandroid.fsscheduler.Airlines
import com.flyingandroid.fsscheduler.Airports
import com.flyingandroid.fsscheduler.DaggerFlightAwareComponent
import com.flyingandroid.fsscheduler.Flights
import com.flyingandroid.fsscheduler.billing.DaggerBillingComponent
import com.flyingandroid.fsscheduler.networking.DaggerNetworkingComponent
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class Planner @Inject constructor(
    private val airports: Airports,
    private val airlines: Airlines,
    private val flights: Flights,
) {

    fun plan(icao: String) = runBlocking {
        println(flights.scheduled(icao))
    }
}

fun main() {
    val billingComponent = DaggerBillingComponent.factory().create()
    val networkingComponent = DaggerNetworkingComponent.factory().create()
    val flightAwareComponent = DaggerFlightAwareComponent.factory().create(networkingComponent, billingComponent)
    val planner = DaggerPlannerComponent.factory().create(flightAwareComponent).planner()
    planner.plan("WUK")
}