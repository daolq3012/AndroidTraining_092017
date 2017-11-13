package com.example.sony.training;

import android.app.Application;
import android.content.Intent;

import com.example.sony.training.service.PlayMusicService;

/**
 * Created by phong on 11/13/17.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(this, PlayMusicService.class);
        startService(intent);
    }
}
