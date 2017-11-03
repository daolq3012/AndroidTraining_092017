package com.example.sony.training;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sony.training.adpater.ViewPagerAdpater;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener {

    private ViewPager mLoginRegisterViewPager;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        initEvents();


        ViewPagerAdpater adapter = new ViewPagerAdpater(getSupportFragmentManager());
        adapter.addFragment(new ContainerFragment());
        adapter.addFragment(new RegisterFragment());
        mLoginRegisterViewPager.setAdapter(adapter);
        mLoginRegisterViewPager.setOffscreenPageLimit(0);


    }

    private void initViews() {
        mLoginRegisterViewPager = (UnSwipeViewPager) findViewById(R.id.loginRegisterViewPager);
        mBottomBar = (BottomBar) findViewById(R.id.bottom_navigation);
    }

    private void initEvents() {
        mBottomBar.setOnTabSelectListener(this);
    }

    @Override
    public void onTabSelected(int tabId) {
        switch (tabId) {
            case R.id.tab1:
                mLoginRegisterViewPager.setCurrentItem(0);
                break;
            case R.id.tab2:
                mLoginRegisterViewPager.setCurrentItem(1);
                break;
        }
    }
}
