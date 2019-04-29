package arg.skyscanner.features.journeys

import arg.skyscanner.api.SkyScannerService
import arg.skyscanner.api.model.Response
import io.reactivex.Observable
import java.lang.IllegalArgumentException
import java.util.concurrent.TimeUnit

class JourneyOperations(
    val skyscannerService: SkyScannerService,
    val journeyMapper: JourneyMapper
) {

    /**
     * Poll for journeys every 12 seconds until we receive status UpdatesComplete
     * (Your key will be rate-limited to ~5 queries per minute.)
     */
    fun pollJourneysStream(
        originPlace: String,
        destinationPlace: String,
        inboundDate: String,
        outboundDate: String,
        adults: String,
        cabinclass: String
    ): Observable<Pair<MutableList<JourneyVM>, Boolean>> {
        return skyscannerService.createSession(
            "UK",
            "GBP",
            "en-GB",
            "iata",
            SkyScannerService.API_KEY,
            "on",
            originPlace,
            destinationPlace,
            inboundDate,
            outboundDate,
            adults,
            "0",
            "0",
            cabinclass
        ).flatMap<Response> {
            if (!it.isError) {
                it.response()?.headers()?.get("location")?.let { location ->
                    return@flatMap Observable.interval(0, 12, TimeUnit.SECONDS)
                        .flatMap {
                            skyscannerService.pollJourneys(
                                location,
                                SkyScannerService.API_KEY
                            )
                        }
                        .takeWhile { response -> response.status != "UpdatesComplete" }
                }
                Observable.error(IllegalArgumentException("No header"))
            } else {
                Observable.error(it.error())
            }
        }.map { Pair(journeyMapper.mapToJourneyVMs(it), it.status == "UpdatesComplete") }
    }
}