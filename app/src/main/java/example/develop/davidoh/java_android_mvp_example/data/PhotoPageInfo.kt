package example.develop.davidoh.java_android_mvp_example.data

import com.google.gson.annotations.SerializedName

class PhotoPageInfo {

    var page: Int = 0
    var pages: Int = 0

    @SerializedName("perpage")
    private var perPage: Int = 0
    var total: Int = 0

    @SerializedName("photo")
    var photoList: List<PhotoItem>? = null
    var stat: String? = null

    fun getperPage(): Int {
        return perPage
    }

    fun setperPage(perpage: Int) {
        this.perPage = perpage
    }
}