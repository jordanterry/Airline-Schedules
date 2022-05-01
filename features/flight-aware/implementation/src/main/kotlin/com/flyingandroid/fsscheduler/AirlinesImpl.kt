package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.data.AirlinesDataSource
import com.flyingandroid.fsscheduler.schema.Airline

class AirlinesImpl(
    private val remoteAirlinesDataSource: AirlinesDataSource
) : Airlines {
    override suspend fun byIcao(icao: String): Airline {
        return remoteAirlinesDataSource.byIcao(icao)
    }
}