package com.flyingandroid.fsscheduler

data class OperatorJson(
    val icao: String, // The operator's ICAO code.
    val iata: String? = null, // The operator's IATA code.
    val callsign: String? = null, // The operator's ICAO telephony name (callsign) used with air traffic control.
    val name: String, //The operator's name. Typically the legal business name.
    val country: String? = null, // Country where operator is headquartered.
    val location: String? = null, // Potentially a more specific location where the operator is based. May specify city, state, province, etc.
    val phone: String? = null, // Public phone number for the operator.
    val shortname: String? = null, //Shorter version of the operator's name. Typically the "doing business as" name, when different than "name."
    val url: String? = null, // URL of operator's website.
    val wiki_url: String? = null
)