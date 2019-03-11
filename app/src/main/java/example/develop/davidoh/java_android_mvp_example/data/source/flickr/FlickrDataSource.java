package example.develop.davidoh.java_android_mvp_example.data.source.flickr;

import java.util.List;

import example.develop.davidoh.java_android_mvp_example.data.PhotoItem;
import example.develop.davidoh.java_android_mvp_example.data.PhotoResponse;

public interface FlickrDataSource {
    interface LoadImageCallback {
        void onImageLoaded(int page, List<PhotoItem> items);
        void onDataNotAvailable();
        void onLoadFail(int code, String message);
    }

    void getRecentPhoto(int page, int perPage, LoadImageCallback loadImageCallback);

    void getSearchPhoto(String keyword, int page, int perPage, LoadImageCallback loadImageCallback);
}
