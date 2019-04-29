package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class BookingDetailsLink(

	@field:SerializedName("Method")
	val method: String,

	@field:SerializedName("Uri")
	val uri: String,

	@field:SerializedName("Body")
	val body: String
)