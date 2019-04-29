package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class SegmentsItem(

	@field:SerializedName("Directionality")
	val directionality: String,

	@field:SerializedName("OriginStation")
	val originStation: Int,

	@field:SerializedName("DepartureDateTime")
	val departureDateTime: String,

	@field:SerializedName("ArrivalDateTime")
	val arrivalDateTime: String,

	@field:SerializedName("JourneyMode")
	val journeyMode: String,

	@field:SerializedName("DestinationStation")
	val destinationStation: Int,

	@field:SerializedName("OperatingCarrier")
	val operatingCarrier: Int,

	@field:SerializedName("FlightNumber")
	val flightNumber: String,

	@field:SerializedName("Duration")
	val duration: Int,

	@field:SerializedName("Id")
	val id: Int,

	@field:SerializedName("Carrier")
	val carrier: Int
)