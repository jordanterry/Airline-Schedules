package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.data.FlightsDataSource
import com.flyingandroid.fsscheduler.data.RemoteFlightsDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module(
    includes = [FlightsModule.Bindings::class]
)
object FlightsModule {

    @Remote
    @Provides
    fun providesRemoteFlightDataSource(
        billing: Billing, requestMaker: RequestMaker, moshi: Moshi
    ): FlightsDataSource {
        return RemoteFlightsDataSource(
            billing, requestMaker, moshi
        )
    }

    @Provides
    fun providesFlights(
        @Remote remoteFlightsDataSource: RemoteFlightsDataSource
    ): Flights {
        return FlightsImpl(
            remoteFlightsDataSource = remoteFlightsDataSource
        )
    }

    @Module
    interface Bindings
}