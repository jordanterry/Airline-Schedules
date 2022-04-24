package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.networking.MoshiAdapter
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module(
    includes = [FlightAwareServiceModule::class, AirlinesModule.Bindings::class]
)
object AirlinesModule {

    @Module
    interface Bindings {

        @MoshiAdapter
        @Binds
        @IntoSet
        fun bindsAirlineAdapter(operatorAdapter: OperatorAdapter): Any

        @Binds
        fun bindsAirlines(airlinesImpl: AirlinesImpl): Airlines
    }
}