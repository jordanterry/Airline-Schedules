package com.flyingandroid.fsscheduler.networking

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module
object MoshiModule {
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}