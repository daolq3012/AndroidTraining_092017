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
                SharedPreferences sharedPreferences =
                        MainActivity.this.getSharedPreferences(Constants.SHARE_PREF_NAME,
                                Context.MODE_PRIVATE);
                Boolean isLogin = sharedPreferences.getBoolean(Constants.SHARE_KEY_PREF_LOGIN,
                        false); //Neu co thi lay gia tri ra, con khong mac dinh ket qua la false
                if (isLogin) {
                    Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 2000);
    }
}
