package example.develop.davidoh.java_android_mvp_example.data.source.flickr

import example.develop.davidoh.java_android_mvp_example.data.PhotoItem
import example.develop.davidoh.java_android_mvp_example.data.PhotoResponse
import retrofit2.Call

interface FlickrDataSource {
    fun getRecentPhoto(page: Int, perPage: Int): Call<PhotoResponse>

    fun getSearchPhoto(keyword: String, page: Int, perPage: Int): Call<PhotoResponse>
}
