package com.flyingandroid.fsscheduler

/**
 * Represents a FlightAware pricing tier, info can be found here:
 * https://flightaware.com/commercial/flightxml/pricing_class.rvt
 *
 * This will be used to estimate the cost of each request. This could later be used to inform the cost of regularly
 * updating info from FlightAware.
 */
enum class RequestType(
    val roughCost: Double
) {
    CLASS_1(0.0120),
    CLASS_2(0.0079),
    CLASS_3(0.0020),
    CLASS_4(0.0008);
}
