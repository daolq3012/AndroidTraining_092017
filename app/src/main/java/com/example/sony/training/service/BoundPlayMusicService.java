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
 * Created by Administrator on 11/13/17.
 */

public class BoundPlayMusicService extends Service {

    private MediaPlayer mPlayer;
    private int mediaLengthWhenPause = 0;

    private IBinder mIBinder = new LocalBinder();

    public class LocalBinder extends Binder{
        public BoundPlayMusicService getService(){
            return BoundPlayMusicService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = MediaPlayer.create(this, R.raw.faded);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mPlayer.start();
        return mIBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    public void playMusic(){
        mPlayer.start();
    }

    public void pauseMusic(){
        if (mPlayer.isPlaying()){
            mediaLengthWhenPause = mPlayer.getCurrentPosition();
            mPlayer.pause();
        }
    }

    public void resumeMusic(){
        if (!mPlayer.isPlaying()){
            mPlayer.seekTo(mediaLengthWhenPause);
            mPlayer.start();
        }
    }

    public void stopMusic(){
        mediaLengthWhenPause = 0;
        mPlayer.stop();
        try {
            mPlayer.prepare();
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        mPlayer.release();
        super.onDestroy();
    }
}
