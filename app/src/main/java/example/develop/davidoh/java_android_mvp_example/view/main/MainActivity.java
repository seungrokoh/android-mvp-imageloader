package example.develop.davidoh.java_android_mvp_example.view.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import example.develop.davidoh.java_android_mvp_example.R;
import example.develop.davidoh.java_android_mvp_example.util.ActivityUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private HomeFragment homeFragment = new HomeFragment();
    private CameraFragment cameraFragment = new CameraFragment();
    private MoreFragment moreFragment = new MoreFragment();

    private FrameLayout container;

    private void init(){
        container = findViewById(R.id.container);
        Bundle bundle = new Bundle();
        bundle.putInt(HomeFragment.KEY_TITLE, R.string.title_home);
        homeFragment.setArguments(bundle);

        bundle.clear();
        bundle.putInt(CameraFragment.KEY_TITLE, R.string.title_camera);
        cameraFragment.setArguments(bundle);

        bundle.clear();
        bundle.putInt(moreFragment.KEY_TITLE, R.string.title_more);
        moreFragment.setArguments(bundle);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(),HomeFragment.getInstance(), R.id.container);
                    return true;
                case R.id.navigation_camera:
                    ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), CameraFragment.getInstance(), R.id.container);
                    return true;
                case R.id.navigation_more:
                    ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), MoreFragment.getInstance(), R.id.container);
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
        init();

        ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), HomeFragment.getInstance(), R.id.container);
    }

}
