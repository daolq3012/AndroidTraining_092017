package com.example.sony.training;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSharedPreferences = getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void onLoginButtonClick(View view) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(Constants.SHARE_KEY_PREF_LOGIN,true);
        editor.commit();

        Intent intent = new Intent(this,LoginSuccessActivity.class);
        startActivity(intent);
    }
}
