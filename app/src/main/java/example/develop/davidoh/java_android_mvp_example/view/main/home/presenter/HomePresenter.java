package example.develop.davidoh.java_android_mvp_example.view.main.home.presenter;

import android.os.AsyncTask;

import example.develop.davidoh.java_android_mvp_example.data.source.image.ImageRepository;

public class HomePresenter implements HomeContractor.Presenter {

    private HomeContractor.View view;
    private ImageRepository imageRepository;

    public HomePresenter(HomeContractor.View view, ImageRepository imageRepository) {
        this.view = view;
        this.imageRepository = imageRepository;
    }
    @Override
    public void loadImage() {
        new ImageAsyncTask(view).execute();
    }

    class ImageAsyncTask extends AsyncTask<Object, Object, Object> implements ImageRepository.LoadImageCallback{
        HomeContractor.View view;

        public ImageAsyncTask(HomeContractor.View view) {
            this.view = view;
        }

        @Override
        protected Object doInBackground(Object... objects) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            view.showProgress();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            view.hideProgress();

            imageRepository.loadImageFileName(this);
        }

        // ImageRePository CallBack
        @Override
        public void onImageLoaded(String fileName) {
            view.showImage(fileName);
        }
    }
}
