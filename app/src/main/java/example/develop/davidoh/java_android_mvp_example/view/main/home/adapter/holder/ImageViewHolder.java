package example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import example.develop.davidoh.java_android_mvp_example.R;
import example.develop.davidoh.java_android_mvp_example.data.ImageData;
import example.develop.davidoh.java_android_mvp_example.listener.OnItemClickListener;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private ImageView imageView;

    private Context context;

    private OnItemClickListener onItemClickListener;

    public ImageViewHolder(Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;

        bind(itemView);

    }

    private void bind(View itemView) {
        tvTitle = itemView.findViewById(R.id.tv_title);
        imageView = itemView.findViewById(R.id.img_view);
    }

    public void onBindView(ImageData imageData, int position){
        tvTitle.setText(imageData.getName());


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }
}
