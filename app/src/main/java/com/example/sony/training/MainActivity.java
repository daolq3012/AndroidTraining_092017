package com.example.sony.training;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.example.sony.training.adapter.LoginRegisterPagerAdapter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements FirstFragmentEventListener {
    private ViewPager mViewPager;
    private LoginRegisterPagerAdapter loginRegisterPagerAdapter;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.loginRegisterViewPager);
        mBottomBar = (BottomBar) findViewById(R.id.bottom_navigation);

        loginRegisterPagerAdapter = new LoginRegisterPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(loginRegisterPagerAdapter);

        mViewPager.setOffscreenPageLimit(2);

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.tab1:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.tab2:
                        mViewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override
    public void onButtonClicked() {
        mViewPager.setAdapter(loginRegisterPagerAdapter);
        Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
    }
}
