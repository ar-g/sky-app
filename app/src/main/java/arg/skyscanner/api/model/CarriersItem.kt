package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class CarriersItem(

	@field:SerializedName("ImageUrl")
	val imageUrl: String,

	@field:SerializedName("Id")
	val id: Int,

	@field:SerializedName("Code")
	val code: String,

	@field:SerializedName("Name")
	val name: String,

	@field:SerializedName("DisplayCode")
	val displayCode: String
)