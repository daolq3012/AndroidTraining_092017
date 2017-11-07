package com.example.sony.training;

import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sony.training.adapter.ViewPagerAdaper;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener{

    private BottomBar mBbMain;
    private ViewPager mVpMain;
    private ViewPagerAdaper viewPagerAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mVpMain.setAdapter(viewPagerAdaper);
        initListeners();
    }

    private void initListeners() {
        mBbMain.setOnTabSelectListener(this);
    }

    private void initViews() {
        mBbMain = (BottomBar) findViewById(R.id.mainBottomBar);
        mVpMain = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdaper = new ViewPagerAdaper(getSupportFragmentManager());
    }

    @Override
    public void onTabSelected(int tabId) {
        switch (tabId){
            case R.id.tab1:
                mVpMain.setCurrentItem(0);
                break;
            case R.id.tab2:
                mVpMain.setCurrentItem(1);
                break;
        }
    }
}
