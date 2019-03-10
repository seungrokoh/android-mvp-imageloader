package example.develop.davidoh.java_android_mvp_example.data.source.image;

public class ImageRepository implements ImageDatasource {
    private static ImageRepository imageRepository;
    private ImageLocalData imageLocalData;
    private ImageRemoteData imageRemoteData;

    public static ImageRepository getInstance() {
        if (imageRepository == null){
            synchronized (ImageRepository.class) {
                if (imageRepository == null) {
                    imageRepository = new ImageRepository();
                }
            }
        }
        return imageRepository;
    }

    private ImageRepository() {
        imageLocalData = ImageLocalData.getInstance();
        imageRemoteData = ImageRemoteData.getInstance();
    }


    @Override
    public void loadImageList(LoadImageCallback loadImageCallback, int size) {
        //imageLocalData.loadImageList(loadImageCallback, size);
        imageRemoteData.loadImageList(loadImageCallback, size);
    }
}
