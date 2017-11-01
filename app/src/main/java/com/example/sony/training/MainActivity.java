package com.example.sony.training;

import android.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sony.training.adapter.TestPagerAdapter;

public class MainActivity extends AppCompatActivity{

    private ViewPager mVpTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVpTest = (ViewPager) findViewById(R.id.testViewPager);
        TestPagerAdapter testPagerAdapter = new TestPagerAdapter(getSupportFragmentManager());
        mVpTest.setAdapter(testPagerAdapter);

    }
}
