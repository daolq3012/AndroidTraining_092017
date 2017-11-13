package com.example.sony.training;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sony.training.service.BoundPlayMusicService;

public class BoundPlayMusicServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button boundServiceButton, playMusicButton, pauseMusicButton, resumeMusicButton, stopMusicButton,
            unboundServiceButton;
    private boolean isBound;
    private BoundPlayMusicService mBoundPlayMusicService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isBound = true;
            BoundPlayMusicService.LocalBinder binder= (BoundPlayMusicService.LocalBinder) service;
            mBoundPlayMusicService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_play_music_service);

        boundServiceButton = (Button) findViewById(R.id.boundServiceBtn);
        playMusicButton = (Button) findViewById(R.id.playMusicButton);
        pauseMusicButton = (Button) findViewById(R.id.pauseMusicBtn);
        resumeMusicButton = (Button) findViewById(R.id.resumeMusic);
        stopMusicButton = (Button) findViewById(R.id.stopMusic);
        unboundServiceButton = (Button) findViewById(R.id.unboundMucsicBtn);

        boundServiceButton.setOnClickListener(this);
        playMusicButton.setOnClickListener(this);
        pauseMusicButton.setOnClickListener(this);
        resumeMusicButton.setOnClickListener(this);
        stopMusicButton.setOnClickListener(this);
        unboundServiceButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boundServiceBtn:
                Intent intent = new Intent(this,BoundPlayMusicService.class);
                bindService(intent,mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.playMusicButton:
                if (isBound){
                    mBoundPlayMusicService.playMusic();
                }
                break;
            case R.id.pauseMusicBtn:
                if (isBound){
                    mBoundPlayMusicService.pauseMusic();
                }
                break;
            case R.id.resumeMusic:
                if (isBound){
                    mBoundPlayMusicService.resumeMusic();
                }
                break;
            case R.id.stopMusic:
                if (isBound){
                    mBoundPlayMusicService.stopMusic();
                }
                break;
            case R.id.unboundMucsicBtn:
                unbindService(mServiceConnection);
                break;
        }
    }
}
