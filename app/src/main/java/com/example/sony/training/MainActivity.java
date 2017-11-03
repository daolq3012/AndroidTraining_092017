package com.example.sony.training;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.sony.training.Adapter.TestPagerAdapter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements FirstFragmentEventListenner{
    private ViewPager testViewPager;
    private BottomBar bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testViewPager = (ViewPager) findViewById(R.id.testViewPager);
        final TestPagerAdapter testPagerAdapter = new TestPagerAdapter(getSupportFragmentManager());
        testViewPager.setAdapter(testPagerAdapter);

        bottomBar = (BottomBar) findViewById(R.id.bottom_bar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab1:
                        testViewPager.setCurrentItem(0);
                        break;
                    case R.id.tab2:
                        testViewPager.setCurrentItem(1);
                        break;
                }

            }
        });
    }

    @Override
    public void onButtonClick() {

    }
}
