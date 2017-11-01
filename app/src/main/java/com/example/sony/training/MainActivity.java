package com.example.sony.training;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sony.training.adapter.TestPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager testViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testViewPager = (ViewPager) findViewById(R.id.testViewPager);
        TestPagerAdapter adapter = new TestPagerAdapter(getSupportFragmentManager());
        testViewPager.setAdapter(adapter);
    }
}
