package com.example.sony.training;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences =
                        MainActivity.this.getSharedPreferences(Constant.SHARE_PREF_NAME,
                                Context.MODE_PRIVATE);
                Boolean isLogin = preferences.getBoolean(Constant.SHARE_KEY_PREF_LOGIN, false);
                if (isLogin) {
                    Intent intent = new Intent(getApplicationContext(), LoginSuccessActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
