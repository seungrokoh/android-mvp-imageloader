package example.develop.davidoh.java_android_mvp_example.view.custom;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.Nullable;

import example.develop.davidoh.java_android_mvp_example.R;

public class GlideImageview extends AppCompatImageView {
    private Context context;
    private AttributeSet attrs;
    private int defStyleAttr;

    public GlideImageview(Context context) {
        super(context);
        this.context = context;
        attrs = null;
        defStyleAttr = 0;
    }

    public GlideImageview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        this.defStyleAttr = 0;
    }

    public GlideImageview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        this.defStyleAttr = defStyleAttr;
    }

    public void loadImages(@Nullable String url) {
        @DrawableRes
        int loadingImageRes = R.drawable.ic_bubble_chart_white_50dp;
        Glide.with(this)
                .load(url)
                .apply(RequestOptions.placeholderOf(loadingImageRes).centerCrop())
                .into(this);

    }
}
