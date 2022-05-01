package com.flyingandroid.fsscheduler

import com.flyingandroid.fsscheduler.schema.Origin
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OriginJson(
    val code: String,
    val code_icao: String? = null,
    val code_iata: String? = null,
    val code_lid: String? = null,
    val airport_info_url: String? = null,
)


fun OriginJson.toModel(): Origin {
    return Origin(
        icao = code
    )
}