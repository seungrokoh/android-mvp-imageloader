package example.develop.davidoh.java_android_mvp_example.main;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

public class FindItemsInteractor {
    interface OnfinishedListener {
        void onFinished(List<String> items);
    }

    public void findItems(final OnfinishedListener listener){
        new Handler().postDelayed(() -> listener.onFinished(createArrayList()), 2000);
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}
