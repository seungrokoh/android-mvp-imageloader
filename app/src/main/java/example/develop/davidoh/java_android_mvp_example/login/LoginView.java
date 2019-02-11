package example.develop.davidoh.java_android_mvp_example.login;

public interface LoginView {
    void showProgress();
    void hideProgress();

    void setUsernameError();
    void setPasswordError();

    void navigateToHome();
}
