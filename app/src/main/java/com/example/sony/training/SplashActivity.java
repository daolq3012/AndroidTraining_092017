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
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                mPreferences = getApplicationContext().getSharedPreferences(Constant.SHARE_PREF_NAME,
                        Context.MODE_PRIVATE);
                boolean isLogin = mPreferences.getBoolean(Constant.SHARE_PREF_LOGIN_SUCCESS, false);
                if (isLogin){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginForm.class);
                    startActivity(intent);
                }
            }
        };
        mHandler = new Handler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mRunnable, 1500);
    }
}
