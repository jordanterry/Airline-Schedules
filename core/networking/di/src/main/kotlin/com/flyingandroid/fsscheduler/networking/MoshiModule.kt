package com.flyingandroid.fsscheduler.networking

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module(includes = [MoshiModule.MultiBindings::class])
object MoshiModule {

    @Provides
    fun providesMoshi(@MoshiAdapter adapters: Set<@JvmSuppressWildcards Any>): Moshi {
        return Moshi.Builder().apply {
            for (adapter in adapters) {
                add(adapter)
            }
            add(KotlinJsonAdapterFactory())
        }.build()
    }

    @Provides
    fun providesMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Module
    interface MultiBindings {
        @Named("MoshiAdapters")
        @Multibinds
        fun multiBindsMoshiAdapters(): Set<@JvmSuppressWildcards Any>
    }
}