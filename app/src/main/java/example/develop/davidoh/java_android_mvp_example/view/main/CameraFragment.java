package example.develop.davidoh.java_android_mvp_example.view.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.develop.davidoh.java_android_mvp_example.R;

public class CameraFragment extends Fragment {
    public static final String KEY_TITLE = "key_title";

    public static CameraFragment getInstance(){
        return new CameraFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView message = view.findViewById(R.id.message);
        //message.setText(getArguments().getInt(KEY_TITLE));
    }
}
