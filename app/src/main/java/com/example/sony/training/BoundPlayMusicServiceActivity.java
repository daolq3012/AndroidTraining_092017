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

public class BoundPlayMusicServiceActivity extends AppCompatActivity implements
        View.OnClickListener {

    private Button mBtnBoundService, mBtnPlayMusic, mBtnPauseMusic, mBtnResumeMusic, mBtnStopMusic,
            mBtnUnboundService;

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

        initViews();

        mBtnBoundService.setOnClickListener(this);
        mBtnPlayMusic.setOnClickListener(this);
        mBtnPauseMusic.setOnClickListener(this);
        mBtnResumeMusic.setOnClickListener(this);
        mBtnStopMusic.setOnClickListener(this);
        mBtnUnboundService.setOnClickListener(this);
    }

    private void initViews() {
        mBtnBoundService = (Button) findViewById(R.id.boundServiceButton);
        mBtnPlayMusic = (Button) findViewById(R.id.playMusicButton);
        mBtnPauseMusic = (Button) findViewById(R.id.pauseMusicButton);
        mBtnResumeMusic = (Button) findViewById(R.id.resumeMusicButton);
        mBtnStopMusic = (Button) findViewById(R.id.stopMusicButton);
        mBtnUnboundService = (Button) findViewById(R.id.unboundServiceButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boundServiceButton: //Chay service
                Intent intent = new Intent(this,BoundPlayMusicService.class);
                bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.playMusicButton:
                if (isBound) {
                    mBoundPlayMusicService.playMusic();
                }
                break;
            case R.id.pauseMusicButton:
                if(isBound) {
                    mBoundPlayMusicService.pauseMusic();
                }
                break;
            case R.id.resumeMusicButton:
                if(isBound) {
                    mBoundPlayMusicService.resumeMusic();
                }
                break;
            case R.id.stopMusicButton:
                if (isBound) {
                    mBoundPlayMusicService.stopMusic();
                }
                break;
            case R.id.unboundServiceButton:
                unbindService(mServiceConnection);
                break;
        }
    }
}
