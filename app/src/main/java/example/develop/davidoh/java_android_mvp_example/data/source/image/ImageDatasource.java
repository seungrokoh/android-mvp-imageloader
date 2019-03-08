package example.develop.davidoh.java_android_mvp_example.data.source.image;

public interface ImageDatasource {
    interface LoadImageCallback {
        // 로드 성공시 데이터를 넘겨줌
        void onImageLoaded(String fileName);
    }

    void loadImageFileName(LoadImageCallback loadImageCallback);
}
