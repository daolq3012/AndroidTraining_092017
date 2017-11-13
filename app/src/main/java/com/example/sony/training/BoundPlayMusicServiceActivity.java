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

public class BoundPlayMusicServiceActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button boundServiceButton, playMusicButton, pauseMusicButton, resumeMusicButton,
            stopMusicButton, unboundServiceButton;

    private boolean isBound;
    private BoundPlayMusicService mBoundPlayMusicService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            isBound = true;
            BoundPlayMusicService.LocalBinder binder = (BoundPlayMusicService.LocalBinder) iBinder;
            mBoundPlayMusicService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_play_music_service);

        boundServiceButton = (Button) findViewById(R.id.boundServiceButton);
        playMusicButton = (Button) findViewById(R.id.playMusic);
        pauseMusicButton = (Button) findViewById(R.id.pauseMusic);
        resumeMusicButton = (Button) findViewById(R.id.resumMusic);
        stopMusicButton = (Button) findViewById(R.id.stopMusic);
        unboundServiceButton = (Button) findViewById(R.id.unboundService);

        boundServiceButton.setOnClickListener(this);
        playMusicButton.setOnClickListener(this);
        pauseMusicButton.setOnClickListener(this);
        resumeMusicButton.setOnClickListener(this);
        stopMusicButton.setOnClickListener(this);
        unboundServiceButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boundServiceButton:
                Intent intent = new Intent(this, BoundPlayMusicService.class);
                bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.playMusic:
                if (isBound) {
                    mBoundPlayMusicService.playMusic();
                }
                break;
            case R.id.pauseMusic:
                if (isBound) {
                    mBoundPlayMusicService.pauseMusic();
                }
                break;
            case R.id.resumMusic:
                if (isBound) {
                    mBoundPlayMusicService.resumeMusic();
                }
                break;
            case R.id.stopMusic:
                if (isBound) {
                    mBoundPlayMusicService.stopMusic();
                }
                break;
            case R.id.unboundService:
                unbindService(mServiceConnection);
                break;
        }
    }
}
