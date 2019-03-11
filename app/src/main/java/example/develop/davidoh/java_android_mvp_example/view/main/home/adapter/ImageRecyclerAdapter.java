package example.develop.davidoh.java_android_mvp_example.view.main.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.develop.davidoh.java_android_mvp_example.data.PhotoItem;
import example.develop.davidoh.java_android_mvp_example.listener.OnItemClickListener;
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.holder.ImageViewHolder;
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.model.ImageRecyclerModel;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageViewHolder> implements ImageRecyclerModel{

    private Context context;
    private List<PhotoItem> imageList = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public ImageRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new ImageViewHolder(context, parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.onBindView(getItem(position), position);
    }

    @Override
    public void addItem(PhotoItem item) {
        imageList.add(item);
    }

    @Override
    public PhotoItem getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    @Override
    public void notifyDataSetChange() {
        notifyDataSetChanged();
    }


}
