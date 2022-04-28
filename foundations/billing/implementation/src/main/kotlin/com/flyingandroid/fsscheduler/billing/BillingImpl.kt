package com.flyingandroid.fsscheduler.billing

import javax.inject.Inject

class BillingImpl @Inject constructor() : Billing {
    override fun record(billableAction: BillableAction) {
        println(billableAction)
    }
}