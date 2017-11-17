package com.example.sony.training;

import android.app.Application;
import com.example.sony.training.database.AndroidTrainingDatabase;

/**
 * Created by Administrator on 11/15/17.
 */

public class MainApplication extends Application {

    private AndroidTrainingDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = AndroidTrainingDatabase.initDatabase(this);
    }

    public AndroidTrainingDatabase getDatabase() {
        return mDatabase;
    }
}
