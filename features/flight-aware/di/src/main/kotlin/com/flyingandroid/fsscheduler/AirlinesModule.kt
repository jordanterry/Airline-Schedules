package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.billing.Billing
import com.flyingandroid.fsscheduler.data.AirlinesDataSource
import com.flyingandroid.fsscheduler.data.RemoteAirlinesDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module(
    includes = [AirlinesModule.Bindings::class]
)
object AirlinesModule {

    @Remote
    @Provides
    fun providesRemoteAirlinesDataSource(
        billing: Billing, requestMaker: RequestMaker, moshi: Moshi
    ): AirlinesDataSource {
        return RemoteAirlinesDataSource(
            billing, requestMaker, moshi
        )
    }

    @Provides
    fun providesAirlines(
        @Remote remoteAirlinesDataSource: AirlinesDataSource
    ): Airlines {
        return AirlinesImpl(
            remoteAirlinesDataSource = remoteAirlinesDataSource
        )
    }

    @Module
    interface Bindings
}