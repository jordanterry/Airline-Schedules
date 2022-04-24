package com.flyingandroid.fsscheduler.schema

import java.util.*

data class Destination(
    val airport: Airport,
    val gate: Gate,
    val estimateTime: Date,
    val actualTime: Date,
)
