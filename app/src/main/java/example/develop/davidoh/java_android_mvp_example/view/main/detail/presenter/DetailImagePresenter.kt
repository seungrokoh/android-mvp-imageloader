package example.develop.davidoh.java_android_mvp_example.view.main.detail.presenter

import example.develop.davidoh.java_android_mvp_example.data.source.image.ImageRepository

class DetailImagePresenter(val view: DetailImageContract.View,
                           private val repository: ImageRepository): DetailImageContract.Presenter {

}