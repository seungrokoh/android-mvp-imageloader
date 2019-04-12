package example.develop.davidoh.java_android_mvp_example.data.source.flickr

import example.develop.davidoh.java_android_mvp_example.data.PhotoInfo
import example.develop.davidoh.java_android_mvp_example.network.FlickrServiceInterface
import example.develop.davidoh.java_android_mvp_example.network.createRetrofit
import retrofit2.Call

class FlickrRemoteData: FlickrDataSource {

    companion object {
        const val FLICKR_API = "https://api.flickr.com/services/rest/"
    }

    private val flickrServiceInterface = createRetrofit(FlickrServiceInterface::class.java, FLICKR_API)

    override fun getRecentPhoto(page: Int, perPage: Int) = flickrServiceInterface.getFlickrRecentPhotos(page, perPage)


    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
            = flickrServiceInterface.getFlickrSearchPhotos(
            keyword = keyword,
            page = page,
            perPage = perPage
    )

    override fun getPhotoDetail(photoId: String): Call<PhotoInfo>
            = flickrServiceInterface.getFlickrPhotoDetail(photoId)
}
