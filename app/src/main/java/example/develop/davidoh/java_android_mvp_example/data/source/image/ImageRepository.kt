package example.develop.davidoh.java_android_mvp_example.data.source.image

import example.develop.davidoh.java_android_mvp_example.data.ImageData

class ImageRepository : ImageDataSource {
    private val IMAGE_REMOTE_DATA: ImageRemoteData by lazy {
        ImageRemoteData()
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        IMAGE_REMOTE_DATA.loadImageList(imageDataList, size)
    }
}
