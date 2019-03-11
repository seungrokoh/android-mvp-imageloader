package example.develop.davidoh.java_android_mvp_example.network;

import example.develop.davidoh.java_android_mvp_example.BuildConfig;
import example.develop.davidoh.java_android_mvp_example.data.PhotoResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FlickrServiceInterface {

    @POST("?method=flickr.photos.getRecent&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    Call<PhotoResponse> getFlickrRecentPhotos(
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    @POST("?method=flickr.photos.search&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    Call<PhotoResponse> getFlickrSearchPhotos (
            @Query("text") String keyword,
            @Query("safe_search") int safeSearch,
            @Query("page") int page,
            @Query("per_page") int perPage
    );
}
