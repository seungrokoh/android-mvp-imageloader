package example.develop.davidoh.java_android_mvp_example.main;

import java.util.List;

public interface MainView {
    void showProgress();
    void hideProgress();

    void setItems(List<String> items);
    void showMessage(String message);
}
