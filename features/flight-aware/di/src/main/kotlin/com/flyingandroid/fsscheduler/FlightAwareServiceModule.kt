package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.networking.MoshiModule
import com.flyingandroid.fsscheduler.networking.OkHttpModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(includes = [OkHttpModule::class, MoshiModule::class])
class FlightAwareServiceModule {
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://aeroapi.flightaware.com/aeroapi/")
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient).build()
    }

    @Provides
    fun providesFlightAwareService(retrofit: Retrofit): FlightAwareService {
        return retrofit.create(FlightAwareService::class.java)
    }
}