package com.example.sony.training.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.example.sony.training.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/14/17.
 */

public class MusicService extends Service {

    private List<Integer> mList;
    private MediaPlayer mPlayer;
    private int mediaLength = 0;
    private int position = 0;
    private IBinder mIBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public MusicService getService(){
            return MusicService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getMusic();
        mPlayer = MediaPlayer.create(this, mList.get(position));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
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
            mediaLength = mPlayer.getCurrentPosition();
            mPlayer.pause();
        }
    }

    public void forwardMusic(){
        if (mPlayer.isPlaying()){
            mPlayer.stop();
            mPlayer.release();
            mPlayer = MediaPlayer.create(this, mList.get(position));
            mPlayer.start();
        } else {
            mPlayer = MediaPlayer.create(this, mList.get(position));
            mPlayer.start();
        }
    }

    public void seekToMusic(){
        if (mPlayer.isPlaying()){
            mPlayer.seekTo(mediaLength);
        }
    }

    @Override
    public void onDestroy() {
        mPlayer.release();
        super.onDestroy();
    }

    private List<Integer> getMusic(){
        mList = new ArrayList<>();
        mList.add(R.raw.ladadee);
        mList.add(R.raw.marryyou);
        mList.add(R.raw.marvingaye);
        return mList;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Integer> getList() {
        return mList;
    }

    public MediaPlayer getPlayer() {
        return mPlayer;
    }

    public int getMediaLength() {
        return mediaLength;
    }

    public void setMediaLength(int mediaLength) {
        this.mediaLength = mediaLength;
    }
}
