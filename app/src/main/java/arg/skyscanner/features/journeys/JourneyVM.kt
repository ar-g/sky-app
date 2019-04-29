package arg.skyscanner.features.journeys

data class JourneyVM(
    val id: String,
    val outboundLeg: LegVM,
    val inboundLeg: LegVM,
    val price: String,
    val ticketAgent: String,
    val satisfaction: String
)

data class LegVM(
    val time: String,
    val description: String,
    val duration: String,
    val direction: String,
    val airlineIcon: String
)