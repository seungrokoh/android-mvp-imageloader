package example.develop.davidoh.java_android_mvp_example.view.main.home.presenter;

import android.os.AsyncTask;

import java.util.List;

import example.develop.davidoh.java_android_mvp_example.data.ImageData;
import example.develop.davidoh.java_android_mvp_example.data.source.image.ImageRepository;
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.model.ImageRecyclerModel;

public class HomePresenter implements HomeContractor.Presenter {

    private HomeContractor.View view;
    private ImageRepository imageRepository;
    private ImageRecyclerModel imageRecyclerModel;
    private boolean isLoading;

    public HomePresenter(HomeContractor.View view, ImageRepository imageRepository, ImageRecyclerModel imageRecyclerModel) {
        this.view = view;
        this.imageRepository = imageRepository;
        this.imageRecyclerModel = imageRecyclerModel;
        isLoading = false;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    @Override
    public void loadImage() {
        new ImageAsyncTask(this, view, imageRepository, imageRecyclerModel).execute();
    }

    class ImageAsyncTask extends AsyncTask<Object, Object, Object> implements ImageRepository.LoadImageCallback{
        private HomePresenter homePresenter;
        private HomeContractor.View view;
        private ImageRepository imageRepository;
        private ImageRecyclerModel imageRecyclerModel;

        public ImageAsyncTask(HomePresenter homePresenter, HomeContractor.View view, ImageRepository imageRepository, ImageRecyclerModel imageRecyclerModel) {
            this.homePresenter = homePresenter;
            this.view = view;
            this.imageRepository = imageRepository;
            this.imageRecyclerModel = imageRecyclerModel;
        }

        @Override
        protected Object doInBackground(Object... objects) {
            try {
                imageRepository.loadImageList(this, 10);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            homePresenter.setLoading(true);
            view.showProgress();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            imageRecyclerModel.notifyDataSetChange();
            view.hideProgress();

            homePresenter.setLoading(false);
        }

        // ImageRePository CallBack
        @Override
        public void onImageLoaded(List<ImageData> imageDataList) {
            for (ImageData item : imageDataList) {
                imageRecyclerModel.addItem(item);
            }
            view.showImageLoaded();
        }
    }
}
