package example.develop.davidoh.java_android_mvp_example.data.source.image

import example.develop.davidoh.java_android_mvp_example.data.ImageData

interface ImageDataSource {

    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}