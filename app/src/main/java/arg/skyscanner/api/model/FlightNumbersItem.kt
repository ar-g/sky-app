package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class FlightNumbersItem(

	@field:SerializedName("CarrierId")
	val carrierId: Int,

	@field:SerializedName("FlightNumber")
	val flightNumber: String
)