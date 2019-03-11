package example.develop.davidoh.java_android_mvp_example.data.source.flickr;

public class FlickrRepository implements FlickrDataSource{
    private static FlickrRepository flickerRepository;

    private FlickrRemoteData flickrRemoteData;

    public static FlickrRepository getInstance(){
        if (flickerRepository == null){
            synchronized (FlickrRepository.class){
                if (flickerRepository == null){
                    flickerRepository = new FlickrRepository();
                }
            }
        }
        return flickerRepository;
    }

    private FlickrRepository() {
        flickrRemoteData = FlickrRemoteData.getInstance();
    }


    @Override
    public void getRecentPhoto(int page, int perPage, LoadImageCallback loadImageCallback) {
        flickrRemoteData.getRecentPhoto(page, perPage, loadImageCallback);
    }

    @Override
    public void getSearchPhoto(String keyword, int page, int perPage, LoadImageCallback loadImageCallback) {
        flickrRemoteData.getSearchPhoto(keyword, page, perPage, loadImageCallback);
    }
}
