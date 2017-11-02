package com.example.sony.training;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sony.training.adapter.LoginRegisterPagerAdapter;

public class MainActivity extends AppCompatActivity implements FirstFragmentEventListener{
    private ViewPager mVpLoginRegister;
    private LoginRegisterPagerAdapter loginRegisterPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVpLoginRegister = (ViewPager) findViewById(R.id.loginRegisterViewPager);
        loginRegisterPagerAdapter = new LoginRegisterPagerAdapter(getSupportFragmentManager());
        mVpLoginRegister.setAdapter(loginRegisterPagerAdapter);

    }

    @Override
    public void onButtonClicked() {
        mVpLoginRegister.setAdapter(loginRegisterPagerAdapter);
        Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
    }
}
