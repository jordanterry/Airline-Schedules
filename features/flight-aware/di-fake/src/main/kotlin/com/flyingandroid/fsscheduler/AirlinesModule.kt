package com.flyingandroid.fsscheduler

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [AirlinesModule.Bindings::class]
)
object AirlinesModule {
    @Module
    interface Bindings {
        @Binds
        @Singleton
        fun bindsAirlines(airlinesImpl: AirlinesFakeImpl): Airlines
    }
}