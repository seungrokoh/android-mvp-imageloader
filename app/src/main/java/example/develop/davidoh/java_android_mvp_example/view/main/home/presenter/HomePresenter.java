package example.develop.davidoh.java_android_mvp_example.view.main.home.presenter;

import java.util.List;

import example.develop.davidoh.java_android_mvp_example.data.PhotoItem;
import example.develop.davidoh.java_android_mvp_example.data.source.flickr.FlickrDataSource;
import example.develop.davidoh.java_android_mvp_example.data.source.flickr.FlickrRepository;
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.model.ImageRecyclerModel;

public class HomePresenter implements HomeContractor.Presenter {

    private HomeContractor.View view;
    private FlickrRepository flickrRepository;
    private ImageRecyclerModel imageRecyclerModel;
    private boolean isLoading;

    private int page = 0;
    private int perPage = 50;

    public HomePresenter(HomeContractor.View view, FlickrRepository flickrRepository, ImageRecyclerModel imageRecyclerModel) {
        this.view = view;
        this.flickrRepository = flickrRepository;
        this.imageRecyclerModel = imageRecyclerModel;
        isLoading = false;

        page = 0;
        perPage = 50;
    }

    public void setPage(int page){
        this.page = page;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }


    @Override
    public void loadFlickrImage() {
        flickrRepository.getSearchPhoto("Eiffel Tower", ++page, perPage, new FlickrDataSource.LoadImageCallback() {

            @Override
            public void onImageLoaded(int page, List<PhotoItem> items) {
                setPage(page);

                for (PhotoItem item : items) {
                    imageRecyclerModel.addItem(item);
                }
                imageRecyclerModel.notifyDataSetChange();

                view.hideProgress();
                isLoading = false;
            }

            @Override
            public void onDataNotAvailable() {
                view.hideProgress();
                view.showLoadFail();
                isLoading = false;
            }

            @Override
            public void onLoadFail(int code, String message) {
                view.hideProgress();
                view.showLoadFail(message);
                isLoading = false;
            }
        });
    }
}
