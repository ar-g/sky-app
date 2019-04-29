package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class LegsItem(

	@field:SerializedName("SegmentIds")
	val segmentIds: List<Int>,

	@field:SerializedName("Duration")
	val duration: Int,

	@field:SerializedName("Arrival")
	val arrival: String,

	@field:SerializedName("Carriers")
	val carriers: List<Int>,

	@field:SerializedName("Directionality")
	val directionality: String,

	@field:SerializedName("OriginStation")
	val originStation: Int,

	@field:SerializedName("Departure")
	val departure: String,

	@field:SerializedName("FlightNumbers")
	val flightNumbers: List<FlightNumbersItem>,

	@field:SerializedName("JourneyMode")
	val journeyMode: String,

	@field:SerializedName("DestinationStation")
	val destinationStation: Int,

	@field:SerializedName("Stops")
	val stops: List<Any>,

	@field:SerializedName("OperatingCarriers")
	val operatingCarriers: List<Int>,

	@field:SerializedName("Id")
	val id: String
)