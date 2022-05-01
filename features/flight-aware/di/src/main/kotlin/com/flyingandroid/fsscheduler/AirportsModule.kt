package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.data.AirportsDataSource
import com.flyingandroid.fsscheduler.data.RemoteAirportsDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module(
    includes = [AirportsModule.Bindings::class]
)
object AirportsModule {

    @Remote
    @Provides
    fun providesRemoteAirportsDataSource(
        billing: Billing, requestMaker: RequestMaker, moshi: Moshi
    ): AirportsDataSource {
        return RemoteAirportsDataSource(
            billing, requestMaker, moshi
        )
    }

    @Provides
    fun providesAirports(
        @Remote remoteAirportsDataSource: AirportsDataSource
    ): Airports {
        return AirportsImpl(
            remoteAirportsDataSource = remoteAirportsDataSource
        )
    }

    @Module
    interface Bindings
}
