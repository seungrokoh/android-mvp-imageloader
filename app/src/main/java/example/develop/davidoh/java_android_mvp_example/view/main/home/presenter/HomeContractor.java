package example.develop.davidoh.java_android_mvp_example.view.main.home.presenter;

public interface HomeContractor {
    interface View {

        void showImage(String result);

        void hideProgress();

        void showProgress();
    }

    interface Presenter {
        void loadImage();
    }
}