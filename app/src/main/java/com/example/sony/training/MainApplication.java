package com.example.sony.training;

import android.app.Application;
import android.content.Intent;
import com.example.sony.training.service.BoundPlayMusicService;
import com.example.sony.training.service.PlayMusicService;

/**
 * Created by Admin on 11/13/17.
 */

public class MainApplication extends Application {

    private int ConnectInternet;

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(this, BoundPlayMusicService.class);
        startService(intent);
    }

    public int getConnectInternet() {
        return ConnectInternet;
    }
}
