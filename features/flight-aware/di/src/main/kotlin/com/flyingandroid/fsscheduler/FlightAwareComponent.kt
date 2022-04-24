package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.BillingComponent
import com.flyingandroid.fsscheduler.networking.NetworkingComponent
import dagger.Component

@Component(
    modules = [
        AirlinesModule::class,
        AirportsModule::class,
        FlightsModule::class,
        FlightAwareServiceModule::class,
        FlightAwareInterceptorsModule::class
    ],
    dependencies = [NetworkingComponent::class, BillingComponent::class]
)
interface FlightAwareComponent {
    fun airports(): Airports
    fun airlines(): Airlines
    fun flights(): Flights

    @Component.Factory
    interface Factory {
        fun create(
            networkingComponent: NetworkingComponent,
            billingComponent: BillingComponent
        ): FlightAwareComponent
    }
}
