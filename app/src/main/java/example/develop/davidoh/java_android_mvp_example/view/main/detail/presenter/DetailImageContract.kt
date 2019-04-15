package example.develop.davidoh.java_android_mvp_example.view.main.detail.presenter

interface DetailImageContract {
    interface View {

        fun updateToolbarItem(buddyIcon: String, buddyName: String)

        fun updateItem(imageUrl: String, title: String, content: String, date: String, viewCount: String, commentCount: String)

        fun showFlickrWebPage(url: String)
    }

    interface Presenter {

        fun loadDetailInfo(photoId: String)

        // Flickr WebPage 주소를 가져와 show
        fun loadFlickrWebPage()
    }
}