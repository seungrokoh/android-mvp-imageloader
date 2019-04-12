package example.develop.davidoh.java_android_mvp_example.view.main.home

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import example.develop.davidoh.java_android_mvp_example.R
import example.develop.davidoh.java_android_mvp_example.data.source.flickr.FlickrRepository
import example.develop.davidoh.java_android_mvp_example.view.main.detail.DetailImageBottomSheet
import example.develop.davidoh.java_android_mvp_example.view.main.home.adapter.ImageRecyclerAdapter
import example.develop.davidoh.java_android_mvp_example.view.main.home.presenter.HomeContractor
import example.develop.davidoh.java_android_mvp_example.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContractor.View {
    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment,
                FlickrRepository,
                imageRecyclerAdapter)
    }

    private val imageRecyclerAdapter : ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this@HomeFragment.context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadFlickrImage()

        recyclerView.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerView!!.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showLoadFail() {
        if (isDetached) return

        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadFail(message: String) {
        if (isDetached) return

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showBottomSheetDialog(photoId: String) {
        if (isDetached) return

        DetailImageBottomSheet.create(photoId).show(activity?.supportFragmentManager, "DetailImageBottomSheet")
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = recyclerView?.childCount as Int
            val totalItemCount = imageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            // 스크롤시 계속해서 로딩
            if (!homePresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 3) {
                homePresenter.loadFlickrImage()
            }
        }
    }
}
