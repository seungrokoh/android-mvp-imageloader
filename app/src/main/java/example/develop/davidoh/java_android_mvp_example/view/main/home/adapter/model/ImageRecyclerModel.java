package example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.model;


import example.develop.davidoh.java_android_mvp_example.data.PhotoItem;

public interface ImageRecyclerModel {
    // 외부에서 RecyclerView에 접근할 수 있는 모델
    void addItem(PhotoItem item);

    PhotoItem getItem(int position);

    int getItemCount();

    void notifyDataSetChange();
}
