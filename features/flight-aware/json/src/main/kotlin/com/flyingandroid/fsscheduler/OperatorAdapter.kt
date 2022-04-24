package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Airline
import com.squareup.moshi.FromJson
import javax.inject.Inject

class OperatorAdapter @Inject constructor() {
    @FromJson
    fun fromOperator(operatorJson: OperatorJson): Airline {
        return Airline(
            name = operatorJson.name,
            icao = operatorJson.icao,
            location = operatorJson.location,
            country = operatorJson.country,
        )
    }
}