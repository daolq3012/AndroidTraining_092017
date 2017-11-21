package com.example.sony.training;

import android.app.Application;

/**
 * Created by phong on 11/21/17.
 */

public class MainApplication extends Application {
    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = AppDatabase.initDatabase(this);
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }
}
