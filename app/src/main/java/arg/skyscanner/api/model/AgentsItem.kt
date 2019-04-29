package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class AgentsItem(

	@field:SerializedName("Status")
	val status: String,

	@field:SerializedName("Type")
	val type: String,

	@field:SerializedName("ImageUrl")
	val imageUrl: String,

	@field:SerializedName("Id")
	val id: Int,

	@field:SerializedName("OptimisedForMobile")
	val optimisedForMobile: Boolean,

	@field:SerializedName("Name")
	val name: String
)