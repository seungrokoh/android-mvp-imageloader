package example.develop.davidoh.java_android_mvp_example.data

import com.google.gson.annotations.SerializedName

class PhotoItem {

    var id: String? = null
    var owner: String? = null
    var secret: String? = null
    var server: String? = null
    var farm: Long = 0
    var title: String? = null
    var viewType: Int = 0

    @SerializedName("ispublic")
    var isPublic: Long = 0

    @SerializedName("isfriend")
    var isFriend: Long = 0

    @SerializedName("isfamily")
    var isFamily: Long = 0
    private val url: String? = null

    fun getUrl(): String {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s.jpg", farm, server, id, secret)
    }
}