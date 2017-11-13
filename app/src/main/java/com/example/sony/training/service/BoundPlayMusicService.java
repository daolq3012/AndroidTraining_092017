package com.example.sony.training.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.example.sony.training.R;
import java.io.IOException;

/**
 * Created by daolq on 11/13/17.
 */

public class BoundPlayMusicService extends Service {

    private MediaPlayer mMediaPlayer;

    private IBinder mIBinder = new LocalBinder();
    private int mediaLengthWhenPause;

    public class LocalBinder extends Binder {
        public BoundPlayMusicService getService() {
            return BoundPlayMusicService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this, R.raw.test);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        playMusic();
        return mIBinder;
    }

    @Override
    public void onDestroy() {
        mMediaPlayer.release();
        super.onDestroy();
    }

    public void playMusic() {
        mMediaPlayer.start();
    }

    public void pauseMusic() {
        if (mMediaPlayer.isPlaying()) {
            mediaLengthWhenPause = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();
        }
    }

    public void resumeMusic() {
        if (!mMediaPlayer.isPlaying()) {
            mMediaPlayer.seekTo(mediaLengthWhenPause);
            mMediaPlayer.start();
        }
    }

    public void stopMusic() {
        mediaLengthWhenPause = 0;
        mMediaPlayer.stop();

        try {
            mMediaPlayer.prepare();
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
