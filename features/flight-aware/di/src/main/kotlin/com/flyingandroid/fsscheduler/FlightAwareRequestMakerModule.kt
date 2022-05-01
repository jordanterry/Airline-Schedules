package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.networking.MoshiAdapter
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        FlightAwareInterceptorsModule::class,
        MoshiAdapterModule::class
    ]
)
class FlightAwareRequestMakerModule {
    @Provides
    fun providesRequestMaker(
        requestMakerBuilder: RequestMaker.Builder,
        interceptors: Set<@JvmSuppressWildcards RequestInterceptor>,
        @MoshiAdapter adapters: Set<@JvmSuppressWildcards Any>,
    ): RequestMaker {
        interceptors.forEach(requestMakerBuilder::addInterceptor)
        return requestMakerBuilder.build()
    }
}