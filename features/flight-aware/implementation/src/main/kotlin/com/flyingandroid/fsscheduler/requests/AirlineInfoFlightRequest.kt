package uk.co.scheduler.schedulertools.apis.flightaware.requests

//import uk.co.scheduler.schedulertools.apis.flightaware.FlightAwareService
//import com.flyingandroid.fsscheduler.models.airline.AirlineInfoResponse
//import uk.co.scheduler.schedulertools.billing.BillableAction
//import uk.co.scheduler.schedulertools.billing.BillingRepository
//
//class AirlineInfoFlightRequest(
//    flightAwareService: FlightAwareService,
//    private val billingRepository: BillingRepository
//) : FlightAwareRequest(flightAwareService) {
//
//    override val type: RequestType
//        get() = RequestType.CLASS_3
//
//    operator fun invoke(icao: String): AirlineInfoResponse? {
//        billingRepository.recordBillable(
//            BillableAction(
//                name = "AirlineInfoFlightRequest",
//                cost = type.roughCost,
//                description = "Request for ariline: $icao"
//            )
//        )
//        val response = flightAwareService.getAirlineInfo(icao).execute()
//        val body = response.body()
//        return if (response.isSuccessful && body != null) body else null
//    }
//}