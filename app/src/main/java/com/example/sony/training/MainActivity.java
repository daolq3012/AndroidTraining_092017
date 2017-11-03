package com.example.sony.training;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sony.training.adapter.LoginRegisterPagerAdapter;
import com.example.sony.training.widget.UnSwipeViewPager;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements FirstFragmentEventListener, OnTabSelectListener {
    private ViewPager mVpLoginRegister;
    private LoginRegisterPagerAdapter loginRegisterPagerAdapter;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mVpLoginRegister.setAdapter(loginRegisterPagerAdapter);
        initListeners();
    }

    private void initViews() {
        mVpLoginRegister = (UnSwipeViewPager) findViewById(R.id.loginRegisterViewPager);
        mBottomBar = (BottomBar) findViewById(R.id.bottom_navigation);

        loginRegisterPagerAdapter = new LoginRegisterPagerAdapter(getSupportFragmentManager());
    }

    private void initListeners(){
        mBottomBar.setOnTabSelectListener(this);
    }

    @Override
    public void onButtonClicked() {
        mVpLoginRegister.setAdapter(loginRegisterPagerAdapter);
        Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabSelected(int tabId) {
        switch (tabId) {
            case R.id.tab1:
                mVpLoginRegister.setCurrentItem(0);
                break;
            case R.id.tab2:
                mVpLoginRegister.setCurrentItem(1);
                break;
        }
    }
}
