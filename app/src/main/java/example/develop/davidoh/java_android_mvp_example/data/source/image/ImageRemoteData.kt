package example.develop.davidoh.java_android_mvp_example.data.source.image

import example.develop.davidoh.java_android_mvp_example.data.ImageData

class ImageRemoteData : ImageDataSource {

    private val imageList = listOf(
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_01.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_02.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_03.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_04.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_05.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_06.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_07.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_08.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_09.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_10.png?raw=true")

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>()
        for (index in 1..size) {
            val randNumber = (1..10).random() + 1
            val url = imageList[randNumber]
            val name = String.format("sample_%02d", randNumber)
            list.add(ImageData(url, name))
        }
        imageDataList(list)
    }
}
