package arg.skyscanner.features.journeys

import android.content.Context
import arg.skyscanner.R
import arg.skyscanner.api.model.CarriersItem
import arg.skyscanner.api.model.LegsItem
import arg.skyscanner.api.model.PlacesItem
import arg.skyscanner.api.model.Response

class JourneyMapper(private val context: Context) {
    fun mapToJourneyVMs(response: Response): MutableList<JourneyVM> {
        val legs = response.legs.associateBy { it.id }
        val places = response.places.associateBy { it.id }
        val carriers = response.carriers.associateBy { it.id }
        val agents = response.agents.associateBy { it.id }
        val currency = response.currencies[0].symbol

        val journeyVMs = mutableListOf<JourneyVM>()

        response.itineraries.forEach { itinerary ->
            val outboundLeg = legs[itinerary.outboundLegId]
            val inboundLeg = legs[itinerary.inboundLegId]
            if (outboundLeg != null && inboundLeg != null) {

                val outboundLegVM = mapToLegVM(outboundLeg, places, carriers)
                val inboundLegVM = mapToLegVM(inboundLeg, places, carriers)
                val price = itinerary.pricingOptions[0].price.toString()
                val formattedPrice = JourneyFormatter.formatPrice(price, currency)
                val agentId = itinerary.pricingOptions[0].agents[0]
                val ticketWebsite = context.getString(R.string.journey_via, agents[agentId]?.name)

                val id = itinerary.inboundLegId + itinerary.outboundLegId

                journeyVMs.add(
                    JourneyVM(
                        id,
                        outboundLegVM,
                        inboundLegVM,
                        formattedPrice,
                        ticketWebsite,
                        "\uD83D\uDE0A 10.0"
                    )
                )
            }
        }
        return journeyVMs
    }

    fun mapToLegVM(leg: LegsItem, places: Map<Int, PlacesItem>, carriers: Map<Int, CarriersItem>): LegVM {
        val time = JourneyFormatter.formatDepartureArrival(leg.departure, leg.arrival)
        val duration = JourneyFormatter.formatDuration(leg.duration.toLong())
        val originStation = places[leg.originStation]?.code ?: ""
        val destinationStation = places[leg.destinationStation]?.code ?: ""
        val carrierName = carriers[leg.carriers[0]]?.name ?: ""
        val carrierImage = carriers[leg.carriers[0]]?.imageUrl ?: ""

        val description = JourneyFormatter.formatDescription(
            originStation,
            destinationStation,
            carrierName
        )
        val direction = if (leg.stops.isEmpty()) {
            context.getString(R.string.journeys_direct)
        } else {
            context.getString(R.string.journeys_not_direct)
        }
        return LegVM(time, description, duration, direction, carrierImage)
    }
}