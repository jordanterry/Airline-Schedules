package com.flyingandroid.fsscheduler.networking

import com.flyingandroid.fsscheduler.RequestMaker
import com.flyingandroid.fsscheduler.RequestMakerImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(
    includes = [OkHttpModule::class]
)
object RequestMakerModule {
    @Provides
    fun providesRequestMakerBuilder(okHttpClient: OkHttpClient): RequestMaker.Builder {
        return RequestMakerImpl.BuilderImpl(
            okHttpClient = okHttpClient
        )
    }
}