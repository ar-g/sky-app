package arg.skyscanner.api.model

import com.google.gson.annotations.SerializedName

data class CurrenciesItem(

	@field:SerializedName("DecimalSeparator")
	val decimalSeparator: String,

	@field:SerializedName("ThousandsSeparator")
	val thousandsSeparator: String,

	@field:SerializedName("SymbolOnLeft")
	val symbolOnLeft: Boolean,

	@field:SerializedName("SpaceBetweenAmountAndSymbol")
	val spaceBetweenAmountAndSymbol: Boolean,

	@field:SerializedName("Symbol")
	val symbol: String,

	@field:SerializedName("DecimalDigits")
	val decimalDigits: Int,

	@field:SerializedName("Code")
	val code: String,

	@field:SerializedName("RoundingCoefficient")
	val roundingCoefficient: Int
)