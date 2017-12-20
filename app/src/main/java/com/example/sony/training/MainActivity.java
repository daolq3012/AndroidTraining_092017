package com.example.sony.training;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sony.training.convert.Utilities;
import com.example.sony.training.service.MusicService;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private ImageView mBtnPrevious, mBtnNext, mBtnPlayAndPause;
    private SeekBar mSbTime;
    private TextView mTxtCurrentTime, mTxtTotalTime;
    private MusicService mService;
    private Utilities mUtilities = new Utilities();
    private boolean isConnect;
    private boolean isMusicPlaying = false;
    private int position;
    private int progressMusic;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isConnect = true;
            //get music service
            MusicService.LocalBinder binder = (MusicService.LocalBinder) service;
            mService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnect = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        connectService();
        initListeners();
    }

    private void initListeners() {
        mBtnPrevious.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        mBtnPlayAndPause.setOnClickListener(this);
        mSbTime.setOnSeekBarChangeListener(this);
    }

    private void initViews() {
        mBtnPrevious = (ImageView) findViewById(R.id.previousButton);
        mBtnNext = (ImageView) findViewById(R.id.nextButton);
        mBtnPlayAndPause = (ImageView) findViewById(R.id.pauseAndPlayButton);
        mTxtCurrentTime = (TextView) findViewById(R.id.currentTimeTextView);
        mTxtTotalTime = (TextView) findViewById(R.id.totalTimeTextView);
        mSbTime = (SeekBar) findViewById(R.id.timeSeekBar);
    }

    private void connectService() {
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    private int getPositionFromService() {
        return mService.getPosition();
    }

    private void changePauseImage() {
        isMusicPlaying = !isMusicPlaying;
        mBtnPlayAndPause.setImageResource(android.R.drawable.ic_media_pause);
    }

    private void changePlayImage() {
        isMusicPlaying = !isMusicPlaying;
        mBtnPlayAndPause.setImageResource(android.R.drawable.ic_media_play);
    }

    private int getProgessMedia() {
        return mService.getPlayer().getDuration();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pauseAndPlayButton:
                if (!isMusicPlaying) {
                    changePauseImage();
                    mService.playMusic();
                    mSbTime.setMax(getProgessMedia());
                } else {
                    changePlayImage();
                    mService.pauseMusic();
                }
                break;
            case R.id.nextButton:
                position = getPositionFromService();
                mSbTime.setProgress(0);
                if (position == mService.getList().size() - 1) {
                    position = 0;
                    mService.setPosition(position);
                    mService.forwardMusic();
                    changePauseImage();
                    mSbTime.setMax(getProgessMedia());
                } else {
                    mService.setPosition(position + 1);
                    mService.forwardMusic();
                    changePauseImage();
                    mSbTime.setMax(getProgessMedia());
                }
                break;
            case R.id.previousButton:
                position = getPositionFromService();
                mSbTime.setProgress(0);
                if (position == 0) {
                    position = mService.getList().size() - 1;
                    mService.setPosition(position);
                    mService.forwardMusic();
                    changePauseImage();
                    mSbTime.setMax(getProgessMedia());
                } else {
                    mService.setPosition(position - 1);
                    mService.forwardMusic();
                    changePauseImage();
                    mSbTime.setMax(getProgessMedia());
                }
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            mService.setMediaLength(progress);
            mService.seekToMusic();
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
            int currentPosition = mService.getPlayer().getCurrentPosition();
            int totalPosition = mService.getPlayer().getDuration();
            String currentSecond = mUtilities.milliSecondsToTimer(currentPosition);
            String totalSecond = mUtilities.milliSecondsToTimer(totalPosition);
            mTxtCurrentTime.setText(currentSecond);
            mTxtTotalTime.setText(totalSecond);
            mSbTime.setProgress(currentPosition);
            position = getPositionFromService();
            if (currentSecond.equals(totalSecond)) {
                mSbTime.setProgress(0);
                if (position == mService.getList().size() - 1) {
                    position = 0;
                    mService.setPosition(position);
                    mService.forwardMusic();
                    changePauseImage();
                    mSbTime.setMax(getProgessMedia());
                } else {
                    mService.setPosition(position + 1);
                    mService.forwardMusic();
                    changePauseImage();
                    mSbTime.setMax(getProgessMedia());
                }
            }
            mHandler.postDelayed(RSetupUI, 1000);
        }
    };
}
