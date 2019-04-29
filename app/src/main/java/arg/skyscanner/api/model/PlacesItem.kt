package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class PlacesItem(

	@field:SerializedName("ParentId")
	val parentId: Int,

	@field:SerializedName("Type")
	val type: String,

	@field:SerializedName("Id")
	val id: Int,

	@field:SerializedName("Code")
	val code: String,

	@field:SerializedName("Name")
	val name: String
)