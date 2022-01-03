package com.flyingandroid.fsscheduler.networking

import dagger.Component

@Component(
    modules = [OkHttpModule::class, InterceptorsModule::class, MoshiModule::class]
)
interface NetworkingComponent {
    @Component.Factory
    interface Factory {
        fun create(): NetworkingComponent
    }
}