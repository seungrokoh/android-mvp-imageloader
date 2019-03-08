package example.develop.davidoh.java_android_mvp_example.view.main.home.presenter;

import android.os.AsyncTask;
import android.widget.ImageView;

import java.util.Random;

import example.develop.davidoh.java_android_mvp_example.util.Util;

public class HomePresenter implements HomeContractor.Presenter {

    private HomeContractor.View view;

    public HomePresenter(HomeContractor.View view) {
        this.view = view;
    }
    @Override
    public void loadImage() {
        new ImageAsyncTask(view).execute();
    }

    class ImageAsyncTask extends AsyncTask<Object, Object, String> {
        HomeContractor.View view;

        public ImageAsyncTask(HomeContractor.View view) {
            this.view = view;
        }
        @Override
        protected String doInBackground(Object... objects) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return String.format("sample%02d", Util.random());
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            view.showProgress();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            view.hideProgress();
            if (result != null) {
                view.showImage(result);
            }

        }
    }
}
