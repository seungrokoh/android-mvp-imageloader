package example.develop.davidoh.java_android_mvp_example.data

data class PhotoResponse(
    val photos: Photos,
    val stat: String,
    val code: Int,  // error code
    val message: String
)

data class Photos(
    val page: Int,
    val pages: String,
    val perpage: Int,
    val photo: List<Photo>,
    val total: String
)

data class Photo(
    val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
) {
    fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}

