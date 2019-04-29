package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class PricingOptionsItem(

	@field:SerializedName("DeeplinkUrl")
	val deeplinkUrl: String,

	@field:SerializedName("Price")
	val price: Double,

	@field:SerializedName("Agents")
	val agents: List<Int>,

	@field:SerializedName("QuoteAgeInMinutes")
	val quoteAgeInMinutes: Int
)