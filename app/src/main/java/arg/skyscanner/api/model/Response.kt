package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Status")
	val status: String,

	@field:SerializedName("Carriers")
	val carriers: List<CarriersItem>,

	@field:SerializedName("Legs")
	val legs: List<LegsItem>,

	@field:SerializedName("Itineraries")
	val itineraries: List<ItinerariesItem>,

	@field:SerializedName("Query")
	val query: Query,

	@field:SerializedName("SessionKey")
	val sessionKey: String,

	@field:SerializedName("Agents")
	val agents: List<AgentsItem>,

	@field:SerializedName("Segments")
	val segments: List<SegmentsItem>,

	@field:SerializedName("Currencies")
	val currencies: List<CurrenciesItem>,

	@field:SerializedName("Places")
	val places: List<PlacesItem>,

	@field:SerializedName("ServiceQuery")
	val serviceQuery: ServiceQuery
)