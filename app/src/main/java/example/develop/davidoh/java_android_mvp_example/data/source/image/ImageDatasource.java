package example.develop.davidoh.java_android_mvp_example.data.source.image;

import java.util.List;

import example.develop.davidoh.java_android_mvp_example.data.ImageData;

public interface ImageDatasource {
    interface LoadImageCallback {
        // 로드 성공시 데이터를 넘겨줌
        void onImageLoaded(List<ImageData> imageDataList);
    }

    void loadImageList(LoadImageCallback loadImageCallback, int size);
}
