package example.develop.davidoh.java_android_mvp_example.data.source.image;

import example.develop.davidoh.java_android_mvp_example.util.Util;

public class ImageLocalData implements ImageDatasource{
    private static ImageLocalData imageLocalData;

    public static ImageLocalData getInstance(){
        if (imageLocalData == null){
            synchronized (ImageLocalData.class) {
                if (imageLocalData == null) {
                    imageLocalData = new ImageLocalData();
                }
            }
        }
        return imageLocalData;
    }

    private ImageLocalData(){}

    @Override
    public void loadImageFileName(LoadImageCallback loadImageCallback) {
        loadImageCallback.onImageLoaded(String.format("sample%02d", Util.random()));
    }
}
