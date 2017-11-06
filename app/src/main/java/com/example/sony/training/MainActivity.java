package com.example.sony.training;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sony.training.adapter.ViewPagerAdapter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener {

    private ViewPager mViewPagerMain;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TimelinesFragment());
        adapter.addFragment(new ProfileFragment());

        mViewPagerMain.setAdapter(adapter);
        mViewPagerMain.setOffscreenPageLimit(2);

    }

    private void initViews() {
        mViewPagerMain = (UnSwipeViewPager) findViewById(R.id.viewPagerMain);
        mBottomBar = (BottomBar) findViewById(R.id.bottom_navigation);
    }

    private void initEvents() {
        mBottomBar.setOnTabSelectListener(this);
    }

    @Override
    public void onTabSelected(int tabId) {
        switch (tabId) {
            case R.id.tab_timelines:
                mViewPagerMain.setCurrentItem(0);
                break;
            case R.id.tab_profile:
                mViewPagerMain.setCurrentItem(1);
                break;
        }
    }
}
