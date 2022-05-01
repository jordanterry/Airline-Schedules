package com.flyingandroid.fsscheduler.networking

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File

@Module
object OkHttpModule {

    @Provides
    fun cache(): Cache {
        return Cache(
            directory = File("./http_cache"),
            maxSize = 50L * 1024L * 1024L
        )
    }

    @Provides
    fun providesOkHttpModule(cache: Cache): OkHttpClient {
        return OkHttpClient
            .Builder()
            .cache(cache)
            .build()
    }
}