package com.example.sony.training.application;

import android.app.Application;
import com.example.sony.training.roomdb.database.Database;

/**
 * Created by Administrator on 11/16/17.
 */

public class MainApplication extends Application {
    private Database mDatabase;
    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = Database.initDatabase(this);
    }

    public Database getDatabase(){
        return mDatabase;
    }
}
