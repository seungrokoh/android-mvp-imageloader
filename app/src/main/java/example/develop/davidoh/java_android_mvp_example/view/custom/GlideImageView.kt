package example.develop.davidoh.java_android_mvp_example.view.custom

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import example.develop.davidoh.java_android_mvp_example.R

class GlideImageView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        AppCompatImageView(context, attrs, defStyleAttr) {

    fun loadImage(url: String?, @DrawableRes loadingImageRes: Int = R.drawable.ic_bubble_chart_white_50dp) {
        Glide.with(this)
                .load(url)
                .apply(RequestOptions.placeholderOf(loadingImageRes).centerCrop())
                .into(this)
    }
}
