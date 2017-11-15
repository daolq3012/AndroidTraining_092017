package com.example.sony.training.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.sony.training.R;

import java.io.IOException;


/**
 * Created by ThanhThang on 14/11/2017.
 */

public class BoundPlayMusicService extends Service {

    private MediaPlayer mMediaPlayer;



    private IBinder mIbinder = new LocalBinder();
    private int mediaLengthWhenPause;
    private int position;
    private int numberSong = 1;
    private boolean isPause = false;

    public class LocalBinder extends Binder {
        public BoundPlayMusicService getService(){
            return BoundPlayMusicService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this, R.raw.chamkhetimanhmotchutthoi_noophuocthinh);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        playMusic();
        return mIbinder;
    }

    @Override
    public void onDestroy() {
        mMediaPlayer.release();
        super.onDestroy();
    }

    public void playMusic(){
        if (isPause){
            isPause = false;
            mMediaPlayer.seekTo(mediaLengthWhenPause);
            mMediaPlayer.start();
        } else {
            if (mMediaPlayer.isPlaying()){

            } else {
                mMediaPlayer.release();
                if (numberSong == 1){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.chamkhetimanhmotchutthoi_noophuocthinh);
                } else if (numberSong == 2){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.vietnamdihonvayeubeat_phamhongphuoc);
                } else if (numberSong == 3){
                    mMediaPlayer = MediaPlayer.create(this, R.raw.kissyou_onedirection);
                }
                mMediaPlayer.start();
            }
        }
    }

    public void pauseMusic(){
        if (mMediaPlayer.isPlaying()){
            isPause = true;
            mediaLengthWhenPause = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();
        }
    }


    public void stopMusic(){
        //mediaLengthWhenPause = 0;
        mMediaPlayer.stop();

        try {
            mMediaPlayer.prepare();
        } catch (IOException|IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void  previousMusic(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();

            if (numberSong == 3){
                numberSong = 2;
                mMediaPlayer = MediaPlayer.create(this, R.raw.vietnamdihonvayeubeat_phamhongphuoc);
            } else if (numberSong == 2){
                numberSong = 1;
                mMediaPlayer = MediaPlayer.create(this, R.raw.chamkhetimanhmotchutthoi_noophuocthinh);
            } else if (numberSong == 1){
                numberSong = 3;
                mMediaPlayer = MediaPlayer.create(this, R.raw.kissyou_onedirection);
            }
            mMediaPlayer.start();
        }
    }

    public void nextMusic(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();

            if (numberSong == 3){
                numberSong = 1;
                mMediaPlayer = MediaPlayer.create(this, R.raw.chamkhetimanhmotchutthoi_noophuocthinh);
            } else if (numberSong == 1){
                numberSong = 2;
                mMediaPlayer = MediaPlayer.create(this, R.raw.vietnamdihonvayeubeat_phamhongphuoc);
            } else if (numberSong == 2){
                numberSong = 3;
                mMediaPlayer = MediaPlayer.create(this, R.raw.kissyou_onedirection);
            }
            mMediaPlayer.start();
        }
    }

    public void seekToMusic(){
        if (mMediaPlayer.isPlaying()){
            mMediaPlayer.seekTo(mediaLengthWhenPause);
        }
    }

    public MediaPlayer getmMediaPlayer (){
        return mMediaPlayer;
    }

    public int getMediaLengthWhenPause(){
        return mediaLengthWhenPause;
    }

    public void setMediaLengthWhenPause(int mediaLengthWhenPause){
        this.mediaLengthWhenPause = mediaLengthWhenPause;
    }
}
