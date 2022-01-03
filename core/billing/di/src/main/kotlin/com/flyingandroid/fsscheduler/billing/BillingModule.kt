package com.flyingandroid.fsscheduler.billing

import dagger.Binds
import dagger.Module

@Module
internal interface BillingModule {
    @Binds
    fun bindsBilling(billingImpl: BillingImpl): Billing
}