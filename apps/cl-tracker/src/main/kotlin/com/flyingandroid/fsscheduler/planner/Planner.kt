package com.flyingandroid.fsscheduler.planner

import com.flyingandroid.fsscheduler.DaggerFlightAwareComponent
import com.flyingandroid.fsscheduler.billing.DaggerBillingComponent
import com.flyingandroid.fsscheduler.networking.DaggerNetworkingComponent
import com.flyingandroid.schedules.DaggerScheduleComponent
import com.flyingandroid.schedules.Schedules
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val billingComponent = DaggerBillingComponent.factory().create()
    val networkingComponent = DaggerNetworkingComponent.factory().create()
    val flightAwareComponent = DaggerFlightAwareComponent.factory().create(networkingComponent, billingComponent)
    val schedules: Schedules = DaggerScheduleComponent.factory().create(flightAwareComponent).schedules()
    println(schedules.airline("WUK"))
}