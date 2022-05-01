package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.networking.MoshiAdapter
import dagger.Module
import dagger.multibindings.Multibinds

@Module(
    includes = [MoshiAdapterModule.MultiBindings::class]
)
object MoshiAdapterModule {
    @Module
    interface MultiBindings {
        @MoshiAdapter
        @Multibinds
        fun multiBindsMoshiAdapters(): Set<@JvmSuppressWildcards Any>
    }
}