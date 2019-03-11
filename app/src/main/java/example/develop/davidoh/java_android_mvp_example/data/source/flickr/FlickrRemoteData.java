package example.develop.davidoh.java_android_mvp_example.data.source.flickr;

import example.develop.davidoh.java_android_mvp_example.data.PhotoResponse;
import example.develop.davidoh.java_android_mvp_example.network.FlickrServiceInterface;
import example.develop.davidoh.java_android_mvp_example.network.RetrofitCreator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrRemoteData implements FlickrDataSource {


    private static FlickrRemoteData flickrRemoteData;

    private final FlickrServiceInterface flickrServiceInterface;
    public static FlickrRemoteData getInstance(){
        if (flickrRemoteData == null){
            synchronized (FlickrRemoteData.class){
                if (flickrRemoteData == null){
                    flickrRemoteData = new FlickrRemoteData();
                }
            }
        }
        return flickrRemoteData;
    }

    private FlickrRemoteData() {
        flickrServiceInterface = RetrofitCreator.createRetrofit().create(FlickrServiceInterface.class);
    }
    @Override
    public void getRecentPhoto(int page, int perPage, LoadImageCallback loadImageCallback) {
        flickrServiceInterface.getFlickrRecentPhotos(page, perPage)
                .enqueue(new Callback<PhotoResponse>() {
                    @Override
                    public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                        if (!response.isSuccessful()) {
                            if (loadImageCallback != null){
                                loadImageCallback.onDataNotAvailable();
                            }
                            return;
                        }

                        // Body를 불러옴. 이 때 이미 GSON에서 변환 된 이후
                        PhotoResponse photoResponse = response.body();

                    }

                    @Override
                    public void onFailure(Call<PhotoResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void getSearchPhoto(String keyword, int page, int perPage, LoadImageCallback loadImageCallback) {
        flickrServiceInterface.getFlickrSearchPhotos(keyword,1,  page, perPage)
                .enqueue(new Callback<PhotoResponse>() {
                    @Override
                    public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                        if (!response.isSuccessful()) {
                            if (loadImageCallback != null) {
                                loadImageCallback.onDataNotAvailable();
                            }
                            return;
                        }

                        PhotoResponse photoResponse = response.body();
                        if (photoResponse != null) {
                            if (photoResponse.getStat().equals("ok") && photoResponse.getPhotoPageInfo() != null) {
                                loadImageCallback.onImageLoaded(photoResponse.getPhotoPageInfo().getPage(),
                                        photoResponse.getPhotoPageInfo().getPhotoList());
                            } else {
                                loadImageCallback.onLoadFail(photoResponse.getCode(), photoResponse.getMessage());
                            }
                        } else {
                            loadImageCallback.onDataNotAvailable();
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotoResponse> call, Throwable t) {
                        if (loadImageCallback != null) {
                            loadImageCallback.onDataNotAvailable();
                        }
                    }
                });
    }
}
