package example.develop.davidoh.java_android_mvp_example.view.main.home.presenter

interface HomeContractor {
    interface View {

        fun hideProgress()
        fun showProgress()

        fun showLoadFail()
        fun showLoadFail(message: String)

        fun showBottomSheetDialog(photoId: String)
    }

    interface Presenter {

        fun loadFlickrImage()
    }
}
