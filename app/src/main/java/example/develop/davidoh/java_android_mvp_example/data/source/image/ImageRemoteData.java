package example.develop.davidoh.java_android_mvp_example.data.source.image;

import java.util.ArrayList;
import java.util.List;

import example.develop.davidoh.java_android_mvp_example.data.ImageData;
import example.develop.davidoh.java_android_mvp_example.util.Util;

public class ImageRemoteData implements ImageDatasource{
    private static ImageRemoteData imageRemoteData;

    public static ImageRemoteData getInstance(){
        if (imageRemoteData == null){
            synchronized (ImageLocalData.class) {
                if (imageRemoteData == null) {
                    imageRemoteData = new ImageRemoteData();
                }
            }
        }
        return imageRemoteData;
    }

    private ImageRemoteData(){}

    private List<String> remoteList = new ArrayList<String>() {
        {
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_01.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_02.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_03.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_04.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_05.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_06.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_07.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_08.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_09.png?raw=true");
            add("https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_10.png?raw=true");
        }
    };
    @Override
    public void loadImageList(LoadImageCallback loadImageCallback, int size) {
        List<ImageData> imageDataList = new ArrayList<>();

        for (int index = 1; index <= size; index++) {
            String url = remoteList.get(Util.random());
            String name = String.format("sample_%02d", Util.random());
            imageDataList.add(new ImageData(url, name));
        }
        loadImageCallback.onImageLoaded(imageDataList);
    }
}
