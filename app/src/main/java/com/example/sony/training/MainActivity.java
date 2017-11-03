package com.example.sony.training;

import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sony.training.adapter.ActivityPagerAdapter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomBar mBottomBar;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        ActivityPagerAdapter adapter = new ActivityPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        intiEvent();
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mBottomBar = (BottomBar) findViewById(R.id.bottom_navigation);
    }

    private void intiEvent() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.tab2:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

}
