package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class Query(

	@field:SerializedName("Locale")
	val locale: String,

	@field:SerializedName("LocationSchema")
	val locationSchema: String,

	@field:SerializedName("Infants")
	val infants: Int,

	@field:SerializedName("InboundDate")
	val inboundDate: String,

	@field:SerializedName("OriginPlace")
	val originPlace: String,

	@field:SerializedName("CabinClass")
	val cabinClass: String,

	@field:SerializedName("Currency")
	val currency: String,

	@field:SerializedName("GroupPricing")
	val groupPricing: Boolean,

	@field:SerializedName("Country")
	val country: String,

	@field:SerializedName("Adults")
	val adults: Int,

	@field:SerializedName("Children")
	val children: Int,

	@field:SerializedName("OutboundDate")
	val outboundDate: String,

	@field:SerializedName("DestinationPlace")
	val destinationPlace: String
)