package com.example.sony.training;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.sony.training.Adapter.TestPagerAdapter;

public class MainActivity extends AppCompatActivity{
    private ViewPager testViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testViewPager = (ViewPager) findViewById(R.id.testViewPager);
        TestPagerAdapter testPagerAdapter = new TestPagerAdapter(getSupportFragmentManager());
        testViewPager.setAdapter(testPagerAdapter);
    }

}
