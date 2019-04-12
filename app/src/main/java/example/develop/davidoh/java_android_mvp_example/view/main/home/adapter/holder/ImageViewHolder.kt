package example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import example.develop.davidoh.java_android_mvp_example.R
import example.develop.davidoh.java_android_mvp_example.data.Photo
import kotlinx.android.synthetic.main.item_image_view.view.*

class ImageViewHolder(onclick: (Int) -> Unit, context: Context?, parent: ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {

    init{
        itemView.setOnClickListener {
            onclick(adapterPosition)
        }
    }
    fun onBind(item: Photo) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: Photo) {
        img_view.loadImage(item.getImageUrl())

    }
}
