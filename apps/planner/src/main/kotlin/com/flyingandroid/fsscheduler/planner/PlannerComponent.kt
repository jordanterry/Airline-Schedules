package com.flyingandroid.fsscheduler.planner

import com.flyingandroid.fsscheduler.FlightAwareComponent
import dagger.Component

@Component(
    dependencies = [FlightAwareComponent::class]
)
interface PlannerComponent {

    fun planner(): Planner

    @Component.Factory
    interface Builder {
        fun create(flightAwareComponent: FlightAwareComponent): PlannerComponent
    }
}