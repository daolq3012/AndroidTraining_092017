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
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.sony.training.service.BoundPlayMusicService;

public class BoundPlayMusicServiceActivity extends AppCompatActivity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private ImageView mBtnPlayMusic, mBtnNextSong, mBtnPreviousSong;
    private SeekBar mSeekBar;

    private TextView mTxtMaxLengthSong, mTxtCurrentDuration;

    private boolean isBound;
    private boolean isPlaying = false;

    private Handler mHandler;
    private Runnable mRunnable;

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

        mHandler = new Handler();

        initViews();
        initEvents();

        Intent intent = new Intent(this, BoundPlayMusicService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                int currentPosition = mBoundPlayMusicService.getMediaPlayer().getCurrentPosition();
                int duration = mBoundPlayMusicService.getMediaPlayer().getDuration();
                String currentTime = Utils.milliSecondsToTimer(currentPosition);
                String totalTime = Utils.milliSecondsToTimer(duration);
                mTxtCurrentDuration.setText(currentTime);
                mSeekBar.setProgress(currentPosition);
                if (currentTime.equals(totalTime)) {
                    mSeekBar.setProgress(0);
                    mBoundPlayMusicService.nextSong();
                    mSeekBar.setMax(mBoundPlayMusicService.getMediaPlayer().getDuration());
                    mTxtMaxLengthSong.setText(Utils.milliSecondsToTimer(
                            mBoundPlayMusicService.getMediaPlayer().getDuration()));
                    mBtnPlayMusic.setImageResource(R.drawable.ic_pause_black_24dp);
                }
                mHandler.postDelayed(mRunnable, 100);
            }
        };
    }

    private void initViews() {
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mBtnPlayMusic = (ImageView) findViewById(R.id.playMusicButton);
        mBtnNextSong = (ImageView) findViewById(R.id.nextSong);
        mBtnPreviousSong = (ImageView) findViewById(R.id.previousSong);
        mTxtMaxLengthSong = (TextView) findViewById(R.id.txtMaxLengthSong);
        mTxtCurrentDuration = (TextView) findViewById(R.id.txtCurrentDuration);
    }

    private void initEvents() {
        mBtnPlayMusic.setOnClickListener(this);
        mBtnNextSong.setOnClickListener(this);
        mBtnPreviousSong.setOnClickListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playMusicButton:
                if (isBound) {
                    if (!isPlaying) {
                        mBoundPlayMusicService.playMusic();
                        mSeekBar.setMax(mBoundPlayMusicService.getMediaPlayer().getDuration());
                        mTxtMaxLengthSong.setText(Utils.milliSecondsToTimer(
                                mBoundPlayMusicService.getMediaPlayer().getDuration()));
                        mBtnPlayMusic.setImageResource(R.drawable.ic_pause_black_24dp);
                        isPlaying = !isPlaying;
                    } else {
                        mBoundPlayMusicService.pauseMusic();
                        mBtnPlayMusic.setImageResource(R.drawable.ic_play);
                        isPlaying = !isPlaying;
                    }
                }
                break;
            case R.id.nextSong:
                if (isBound) {
                    mBoundPlayMusicService.nextSong();
                    mTxtCurrentDuration.setText("0:00");
                    mSeekBar.setProgress(0);
                    mSeekBar.setMax(mBoundPlayMusicService.getMediaPlayer().getDuration());
                    mTxtMaxLengthSong.setText(Utils.milliSecondsToTimer(
                            mBoundPlayMusicService.getMediaPlayer().getDuration()));
                    mBtnPlayMusic.setImageResource(R.drawable.ic_pause_black_24dp);
                }
                break;
            case R.id.previousSong:
                if (isBound) {
                    mTxtCurrentDuration.setText("0:00");
                    mSeekBar.setProgress(0);
                    mBoundPlayMusicService.previousSong();
                    mSeekBar.setMax(mBoundPlayMusicService.getMediaPlayer().getDuration());
                    mTxtMaxLengthSong.setText(Utils.milliSecondsToTimer(
                            mBoundPlayMusicService.getMediaPlayer().getDuration()));
                    mBtnPlayMusic.setImageResource(R.drawable.ic_pause_black_24dp);
                }
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            mBoundPlayMusicService.seekTo(progress);
            seekBar.setProgress(progress);
        } else {
            mHandler.removeCallbacks(mRunnable);
            mHandler.postDelayed(mRunnable, 1000);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
