package example.develop.davidoh.java_android_mvp_example.view.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import example.develop.davidoh.java_android_mvp_example.R;
import example.develop.davidoh.java_android_mvp_example.util.Util;
import example.develop.davidoh.java_android_mvp_example.view.main.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Util.replaceFragmentToActivity(getSupportFragmentManager(),HomeFragment.getInstance(), R.id.container);
                    return true;
                case R.id.navigation_camera:
                    Util.replaceFragmentToActivity(getSupportFragmentManager(), CameraFragment.getInstance(), R.id.container);
                    return true;
                case R.id.navigation_more:
                    Util.replaceFragmentToActivity(getSupportFragmentManager(), MoreFragment.getInstance(), R.id.container);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Util.replaceFragmentToActivity(getSupportFragmentManager(), HomeFragment.getInstance(), R.id.container);
    }

}
