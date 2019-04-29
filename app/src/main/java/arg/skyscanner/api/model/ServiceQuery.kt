package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class ServiceQuery(

	@field:SerializedName("DateTime")
	val dateTime: String
)