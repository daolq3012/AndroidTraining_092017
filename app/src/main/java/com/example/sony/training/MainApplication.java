package com.example.sony.training;

import android.app.Application;
import android.content.Intent;

import com.example.sony.training.Service.PlayMusicService;

/**
 * Created by ThanhThang on 13/11/2017.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(this, PlayMusicService.class);
        startService(intent);
    }
}
