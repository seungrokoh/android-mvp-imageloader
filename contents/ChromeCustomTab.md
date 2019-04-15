# :bulb: ChromeCustomTab

WebView가 아니라 Chrome Native가 설치되어 있는 상태에서 동작하는 View
제약사항이 존재하지만 WebView보다 성능이 좋기 때문에 사용해볼만 하다.

:link: [CromeNative vs ChomeCustomTab vs WebView 속도 비교](https://developer.chrome.com/multidevice/android/customtabs
    )
### :seedling: CustomTab에서 제공해주는 도구

* Toolbar color : Toolbar 색상 변경
* Action button : Action 버튼 생성 가능
* Custom menu items : Custom menu 생성 가능
* Custom in/out animations : 애니메이션 별도로 지정 가능
* Bottom toolbar

:pushpin: 제약사항
WebView는 자유롭게 사용할 수 있지만 __ChromeCustomTab은 Chrome이 설치되어야 있어야 동작을 한다.__

### :seedling: 시작하기

:pushpin: implementation guide

```gradle
dependencies {
    implementation 'com.android.support:customtabs:28.0.0'
}

```

### :seedling: Contract에 행동 추가
```kotlin
interface DetailImageContract {
    interface View {
        ...
        fun showFlickrWebPage(url: String)
    }

    interface Presenter {
        ...
        // Flickr WebPage 주소를 가져와 show
        fun loadflickrWebPage()
    }
}
```

### :seedling: Presenter 작성

```kotlin
class DetailImagePresenter(val view: DetailImageContract.View,
    private val repository: FlickrRepository): DetailImageContract.Presenter {
        private var webUrl: String = ""
        ...
        override fun loadDetailInfo(photoId: String) {
            ...

            webUrl = it.urls.url.firstOrNull()?._content ?: ""
        }
        ...

        override fun loadFlickrWebPage() {
            if (webUrl.isNotEmpty()) {
                view.showFlickrWebPage(webUrl)
            }
        }
    }
```

### :pushpin: View 작성

```kotlin
class DetailImageBottomSheet: BottomSheetDialogFragment(), DetailImageContract.View {
    ...

    img_web.setOnClickListener {
        // Show chrome.
        detailImagePresenter.loadFlickrWebPage()
    }

    ...

    override fun showFlickrWebPage(url: String) {
        CustomTabsIntent.Builder().apply {
            setToolbarColor(resources.getColor(R.color.colorAccent))
            }.build().run {
                launchUrl(context, Uri.parse(url))
            }
        }
    }
```
