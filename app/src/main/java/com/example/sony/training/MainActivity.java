package com.example.sony.training;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.sony.training.Service.BoundPlayMusicService;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Button previousMusicButton, stopMusicButton, playPauseMusicButton, nextMusicButton;
    private SeekBar lengthMusicSeekBar;
    private TextView secondStart, secondTotal;
    private Utilities mUtilities = new Utilities();
    private Handler mHandler = new Handler();

    private Boolean isBound;
    private Boolean isPlay = true;


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
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
        Intent intent = new Intent(this, BoundPlayMusicService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    public void initViews() {
        previousMusicButton = (Button) findViewById(R.id.previousMusicButton);
        stopMusicButton = (Button) findViewById(R.id.stopMusicButton);
        playPauseMusicButton = (Button) findViewById(R.id.play_pauseMusicButton);
        nextMusicButton = (Button) findViewById(R.id.nextMusicButton);
        lengthMusicSeekBar = (SeekBar) findViewById(R.id.lengthMusicSeekBar);
        lengthMusicSeekBar.setClickable(false);
        secondStart = (TextView) findViewById(R.id.secondStart);
        secondTotal = (TextView) findViewById(R.id.secondTotal);
    }

    public void initEvents() {
        previousMusicButton.setOnClickListener(this);
        stopMusicButton.setOnClickListener(this);
        playPauseMusicButton.setBackgroundResource(R.drawable.ic_pause);
        playPauseMusicButton.setOnClickListener(this);
        nextMusicButton.setOnClickListener(this);
        lengthMusicSeekBar.setOnSeekBarChangeListener(this);
    }

    public int getProgressMedia() {
        return mBoundPlayMusicService.getmMediaPlayer().getDuration();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previousMusicButton:
                lengthMusicSeekBar.setProgress(0);
                if (isBound) {
                    mBoundPlayMusicService.previousMusic();
                    lengthMusicSeekBar.setMax(getProgressMedia());
                }
                break;
            case R.id.stopMusicButton:
                if (isBound) {
                    mBoundPlayMusicService.stopMusic();
                }
                break;
            case R.id.play_pauseMusicButton:

                if (!isBound) {
                    mBoundPlayMusicService.playMusic();
                    lengthMusicSeekBar.setMax(getProgressMedia());
                } else {
                    mBoundPlayMusicService.pauseMusic();
                }
                isBound = !isBound;
                if (isPlay) {
                    v.setBackgroundResource(R.drawable.ic_play);
                } else {
                    v.setBackgroundResource(R.drawable.ic_pause);

                }
                isPlay = !isPlay;
                break;
            case R.id.nextMusicButton:
                lengthMusicSeekBar.setProgress(0);
                mBoundPlayMusicService.nextMusic();
                lengthMusicSeekBar.setMax(getProgressMedia());
                break;
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            mBoundPlayMusicService.setMediaLengthWhenPause(progress);
            mBoundPlayMusicService.seekToMusic();
        } else {
            updateUI();
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void updateUI() {
        mHandler.removeCallbacks(RSetupUI);
        mHandler.postDelayed(RSetupUI, 1000);
    }

    private Runnable RSetupUI = new Runnable() {
        @Override
        public void run() {
            int currentPosition = mBoundPlayMusicService.getmMediaPlayer().getCurrentPosition();
            int totalPosition = mBoundPlayMusicService.getmMediaPlayer().getDuration();
            String currentSeconds = mUtilities.milliSecondsToTimer(currentPosition);
            String totalSeconds = mUtilities.milliSecondsToTimer(totalPosition);

            secondStart.setText(currentSeconds);
            secondTotal.setText(totalSeconds);
            lengthMusicSeekBar.setProgress(currentPosition);

            if (currentSeconds.equals(totalSeconds)) {
                lengthMusicSeekBar.setProgress(0);
                mBoundPlayMusicService.nextMusic();
            }
            mHandler.postDelayed(RSetupUI, 1000);
        }
    };

}