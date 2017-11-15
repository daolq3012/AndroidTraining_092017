package com.example.sony.training;

import android.app.Application;

import com.example.sony.training.Database.DatabaseDemo;

/**
 * Created by ThanhThang on 15/11/2017.
 */

public class MainApplication extends Application {

    private DatabaseDemo mDatabaseDemo;
    @Override
    public void onCreate() {
        super.onCreate();
        mDatabaseDemo = DatabaseDemo.initDatabase(this);
    }

    public DatabaseDemo getDatabase(){
        return mDatabaseDemo;
    }
}
