package com.flyingandroid.fsscheduler.networking

import com.flyingandroid.fsscheduler.RequestMaker
import com.flyingandroid.fsscheduler.RequestMakerImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(
    includes = [OkHttpModule::class, MoshiModule::class]
)
object RequestMakerModule {

    @Provides
    fun providesRequestMaker(okHttpClient: OkHttpClient, moshi: Moshi): RequestMaker {
        return RequestMakerImpl(
            okHttpClient = okHttpClient,
            moshi = moshi
        )
    }
}