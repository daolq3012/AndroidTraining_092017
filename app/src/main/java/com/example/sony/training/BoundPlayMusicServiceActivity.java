package com.example.sony.training;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sony.training.Service.BoundPlayMusicService;

public class BoundPlayMusicServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button boundServiceButton, playMusicButton, pauseMusicButton, resumeMusicButton, stopMusicButton,
            unBoundServiceButton;

    private boolean isBound;
    private BoundPlayMusicService mBoundPlayMusicService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            isBound = true;
            BoundPlayMusicService.LocalBinder binder = (BoundPlayMusicService.LocalBinder) iBinder;
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

        boundServiceButton = (Button) findViewById(R.id.boundServiceButton);
        playMusicButton = (Button) findViewById(R.id.playMusicButton);
        pauseMusicButton = (Button) findViewById(R.id.pauseMusicButton);
        resumeMusicButton = (Button) findViewById(R.id.resumeMusicButton);
        stopMusicButton = (Button) findViewById(R.id.stopMusicButton);
        unBoundServiceButton = (Button) findViewById(R.id.unboundServiceButton);

        boundServiceButton.setOnClickListener(this);
        playMusicButton.setOnClickListener(this);
        pauseMusicButton.setOnClickListener(this);
        resumeMusicButton.setOnClickListener(this);
        stopMusicButton.setOnClickListener(this);
        unBoundServiceButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boundServiceButton:
                Intent intent = new Intent(this, BoundPlayMusicService.class);
                bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.playMusicButton:
                if (isBound){
                    mBoundPlayMusicService.playMusic();
                }
                break;
            case R.id.pauseMusicButton:
                if (isBound){
                    mBoundPlayMusicService.pauseMusic();
                }
                break;
            case R.id.resumeMusicButton:
                if (isBound){
                    mBoundPlayMusicService.resumeMusic();
                }
                break;
            case R.id.stopMusicButton:
                if (isBound){
                    mBoundPlayMusicService.stopMusic();
                }
                break;
            case R.id.unboundServiceButton:
                break;
            default:
                break;
        }

    }
}
