package example.develop.davidoh.java_android_mvp_example.data.source.image;

import java.util.ArrayList;
import java.util.List;

import example.develop.davidoh.java_android_mvp_example.data.ImageData;
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
    public void loadImageList(LoadImageCallback loadImageCallback, int size) {
        List<ImageData> imageDataList = new ArrayList<>();

        for (int index = 1; index <= size; index++) {
            String name = String.format("sample%02d", Util.random());
            imageDataList.add(new ImageData(name, name));
        }
        loadImageCallback.onImageLoaded(imageDataList);
    }
}
