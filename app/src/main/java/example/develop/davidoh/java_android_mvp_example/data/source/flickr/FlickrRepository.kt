package example.develop.davidoh.java_android_mvp_example.data.source.flickr

import example.develop.davidoh.java_android_mvp_example.data.PhotoResponse
import retrofit2.Call

object FlickrRepository : FlickrDataSource {

    private val flickrRemoteData = FlickrRemoteData()

    override fun getRecentPhoto(page: Int, perPage: Int): Call<PhotoResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int): Call<PhotoResponse>
            = flickrRemoteData.getSearchPhoto(keyword, page, perPage)

}
