package example.develop.davidoh.java_android_mvp_example.view.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import example.develop.davidoh.java_android_mvp_example.R;
import example.develop.davidoh.java_android_mvp_example.view.main.home.presenter.HomeContractor;
import example.develop.davidoh.java_android_mvp_example.view.main.home.presenter.HomePresenter;

public class HomeFragment extends Fragment implements HomeContractor.View{

    public static final String KEY_TITLE = "key_title";

    private ImageView imageView;
    private ProgressBar progressBar;

    private HomePresenter homePresenter;

    public static HomeFragment getInstance(){
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView);
        progressBar = view.findViewById(R.id.progressBar);

        homePresenter = new HomePresenter(this);
        homePresenter.loadImage();
    }

    @Override
    public void showImage(String imageName) {
        imageView.setImageResource(getResources().getIdentifier(imageName, "drawable", getContext().getPackageName()));
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
