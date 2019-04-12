package example.develop.davidoh.java_android_mvp_example.network

import example.develop.davidoh.java_android_mvp_example.BuildConfig
import example.develop.davidoh.java_android_mvp_example.data.PhotoInfo
import example.develop.davidoh.java_android_mvp_example.data.PhotoResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface FlickrServiceInterface {

    @POST("?method=flickr.photos.getRecent&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    fun getFlickrRecentPhotos(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<PhotoResponse>

    @POST("?method=flickr.photos.search&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrSearchPhotos(
            @Query("text") keyword: String,
            @Query("safe_search") safeSearch: Int = 1,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<PhotoResponse>

    @POST("?method=flickr.photos.getInfo&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrPhotoDetail(
            @Query("photo_id") photoId: String
    ): Call<PhotoInfo>
}
