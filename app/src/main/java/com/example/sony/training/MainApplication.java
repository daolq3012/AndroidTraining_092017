package com.example.sony.training;

import android.app.Application;

/**
 * Created by ThanhThang on 17/11/2017.
 */

public class MainApplication extends Application {
    private UserDatabase mUserDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mUserDatabase = UserDatabase.initDatabase(this);
    }

    public UserDatabase getUserDatabase(){
        return mUserDatabase;
    }
}
