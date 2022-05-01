package com.flyingandroid.schedules

import com.flyingandroid.fsscheduler.FlightAwareComponent
import dagger.Component

@Component(
    modules = [SchedulesModule::class],
    dependencies = [FlightAwareComponent::class]
)
interface ScheduleComponent {
    fun schedules(): Schedules

    @Component.Factory
    interface Factory {
        fun create(
            flightAwareComponent: FlightAwareComponent,
        ): ScheduleComponent
    }
}
