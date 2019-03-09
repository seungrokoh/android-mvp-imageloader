package example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.model;

import example.develop.davidoh.java_android_mvp_example.data.ImageData;

public interface ImageRecyclerModel {
    // 외부에서 RecyclerView에 접근할 수 있는 모델
    void addItem(ImageData item);

    ImageData getItem(int position);

    int getItemCount();

    void notifyDataSetChange();
}
