package com.flyingandroid.fsscheduler.billing

import dagger.Component

@Component(
    modules = [BillingModule::class]
)
interface BillingComponent {
    fun billing(): Billing
    @Component.Factory
    interface Factory {
        fun create(): BillingComponent
    }
}