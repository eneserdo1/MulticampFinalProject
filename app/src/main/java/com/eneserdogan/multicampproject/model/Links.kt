import com.google.gson.annotations.SerializedName




data class Links (

	@SerializedName("instagram") val instagram : String,
	@SerializedName("twitter") val twitter : String,
	@SerializedName("youtube") val youtube : String,
	@SerializedName("participation") val participation : String
)