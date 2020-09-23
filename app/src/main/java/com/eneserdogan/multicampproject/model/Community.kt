import com.google.gson.annotations.SerializedName

data class Community (

	@SerializedName("name") val name : String,
	@SerializedName("description") val description : String,
	@SerializedName("banner") val banner : String,
	@SerializedName("leader") val leader : Leader,
	@SerializedName("links") val links : Links
)