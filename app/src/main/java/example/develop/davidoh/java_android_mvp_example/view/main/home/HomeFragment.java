package example.develop.davidoh.java_android_mvp_example.view.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import example.develop.davidoh.java_android_mvp_example.R;
import example.develop.davidoh.java_android_mvp_example.data.source.image.ImageRepository;
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.ImageRecyclerAdapter;
import example.develop.davidoh.java_android_mvp_example.view.main.home.presenter.HomeContractor;
import example.develop.davidoh.java_android_mvp_example.view.main.home.presenter.HomePresenter;

public class HomeFragment extends Fragment implements HomeContractor.View{

    public static final String KEY_TITLE = "key_title";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private HomePresenter homePresenter;

    private ImageRecyclerAdapter imageRecyclerAdapter;

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
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);

        imageRecyclerAdapter = new ImageRecyclerAdapter(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(imageRecyclerAdapter);
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);

        homePresenter = new HomePresenter(this, ImageRepository.getInstance(), imageRecyclerAdapter);
        homePresenter.loadImage();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView.removeOnScrollListener(recyclerViewOnScrollListener);
    }

    @Override
    public void showImageLoaded() {
        //Toast.makeText(getActivity(), "images loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int visibleItemCount = recyclerView.getChildCount();
            int totalItemCount = imageRecyclerAdapter.getItemCount();
            int firstVisibleItem = 0;

            if ((GridLayoutManager) recyclerView.getLayoutManager() != null) {
                firstVisibleItem = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            }

            // 스크롤 시 계속해서 로딩할 수 있게
            if (!homePresenter.isLoading() && (firstVisibleItem + visibleItemCount) >= totalItemCount - 7) {
                homePresenter.loadImage();
            }


        }
    };
}
