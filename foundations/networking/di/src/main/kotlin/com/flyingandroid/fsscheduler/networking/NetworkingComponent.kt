package com.flyingandroid.fsscheduler.networking

import com.flyingandroid.fsscheduler.RequestMaker
import dagger.Component

@Component(
    modules = [RequestMakerModule::class, InterceptorsModule::class, MoshiModule::class]
)
interface NetworkingComponent {

    fun requestMaker(): RequestMaker

    @Component.Factory
    interface Factory {
        fun create(): NetworkingComponent
    }
}