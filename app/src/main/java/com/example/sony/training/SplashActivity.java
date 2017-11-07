package com.example.sony.training;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = SplashActivity.this.getSharedPreferences(Constants.SHARE_PREF_NAME,
                        Context.MODE_PRIVATE);
                Boolean isLogin = sharedPreferences.getBoolean(Constants.SHARE_PREF_KEY_LOGIN,false);
                if (isLogin) {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        };

        mHandler = new Handler();
        mHandler.postDelayed(mRunnable,1500);

    }
}
