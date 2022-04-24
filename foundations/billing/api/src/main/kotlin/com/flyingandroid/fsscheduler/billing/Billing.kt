package com.flyingandroid.fsscheduler.billing

interface Billing {
    fun record(billableAction: BillableAction)
}

data class BillableAction(
    val name: String,
    val cost: Double,
    val description: String
)