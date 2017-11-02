package com.example.sony.training;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sony.training.adpater.ViewPagerAdpater;

public class MainActivity extends AppCompatActivity {

    private ViewPager mLoginRegisterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginRegisterViewPager = (ViewPager) findViewById(R.id.loginRegisterViewPager);
        ViewPagerAdpater adapter = new ViewPagerAdpater(getSupportFragmentManager());
        adapter.addFragment(new ContainerFragment());
        adapter.addFragment(new RegisterFragment());
        mLoginRegisterViewPager.setAdapter(adapter);
    }
}
