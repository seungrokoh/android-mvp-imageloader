package example.develop.davidoh.java_android_mvp_example.view.main.detail.presenter

import example.develop.davidoh.java_android_mvp_example.data.PhotoInfo
import example.develop.davidoh.java_android_mvp_example.data.source.flickr.FlickrRepository
import example.develop.davidoh.java_android_mvp_example.util.decimalFormat
import example.develop.davidoh.java_android_mvp_example.util.getDate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailImagePresenter(val view: DetailImageContract.View,
                           private val repository: FlickrRepository): DetailImageContract.Presenter {
    private var webUrl: String = ""

    override fun loadDetailInfo(photoId: String) {
        repository.getPhotoDetail(photoId)
                .enqueue(object: Callback<PhotoInfo> {

                    override fun onResponse(call: Call<PhotoInfo>, response: Response<PhotoInfo>) {
                        if (response?.isSuccessful) {
                            response.body()?.takeIf { it.stat == "ok" }?.let {
                                // 처리
                                it.photo.let {
                                    view.updateItem(
                                            it.getImageUrl(),
                                            it.title._content,
                                            it.description._content,
                                            it.dates.lastupdate.getDate("MM-dd-yyyy hh:mm:ss"),
                                            it.views.toString().decimalFormat(),
                                            it.comments._content.toString().decimalFormat())


                                    view.updateToolbarItem(
                                            it.owner.getBuddyIcons(),
                                            it.owner.username)

                                    webUrl = it.urls.url.firstOrNull()?._content ?: ""

                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<PhotoInfo>, t: Throwable) {

                    }
                })

    }


    override fun loadFlickrWebPage() {
        if (webUrl.isNotEmpty()) {
            view.showFlickrWebPage(webUrl)
        }
    }

}
