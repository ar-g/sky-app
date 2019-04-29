package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class ItinerariesItem(

	@field:SerializedName("InboundLegId")
	val inboundLegId: String,

	@field:SerializedName("BookingDetailsLink")
	val bookingDetailsLink: BookingDetailsLink,

	@field:SerializedName("OutboundLegId")
	val outboundLegId: String,

	@field:SerializedName("PricingOptions")
	val pricingOptions: List<PricingOptionsItem>
)