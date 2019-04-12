package example.develop.davidoh.java_android_mvp_example.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import example.develop.davidoh.java_android_mvp_example.data.Photo
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.holder.ImageViewHolder
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.model.ImageRecyclerModel

class ImageRecyclerAdapter(private val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel {
    private val list = mutableListOf<Photo>()

    override lateinit var onclick: (Int) -> Unit

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(onclick, context, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun addItem(imageData: Photo) {
        list.add(imageData)
    }

    override fun getItem(position: Int): Photo {
        return list[position]
    }

    override fun notifyDataSetChange() {
        notifyDataSetChanged()
    }

}
