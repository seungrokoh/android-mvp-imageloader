package example.develop.davidoh.java_android_mvp_example.login;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

public class LoginInteractor {
    interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }

    public void login(final String username, final String password, final OnLoginFinishedListener listener){
        new Handler().postDelayed(() -> {
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError();
                return;
            }
            listener.onSuccess();
        }, 2000);
    }
}
