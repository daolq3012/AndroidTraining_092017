package com.example.sony.training.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.example.sony.training.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/13/17.
 */

public class BoundPlayMusicService extends Service {

    private List<Integer> listSongs = new ArrayList<>();
    private int position = 0;

    private MediaPlayer mMediaPlayer;

    private int mediaLengthWhenPause;

    private IBinder mIBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public BoundPlayMusicService getService() {
            return BoundPlayMusicService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        listSongs.add(R.raw.cry_on_my_shoulder);
        listSongs.add(R.raw.closer);
        listSongs.add(R.raw.kem_duyen);

        mMediaPlayer = MediaPlayer.create(this, listSongs.get(position));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //playMusic(); //Start service thi nhac se chay luon
        return mIBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void playMusic() {
        mMediaPlayer.start();
    }

    public void pauseMusic() {
        if (mMediaPlayer.isPlaying()) {
            //            mediaLengthWhenPause = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();
        }
    }

    public void resumeMusic() {
        if (!mMediaPlayer.isPlaying()) {
            //            mMediaPlayer.seekTo(mediaLengthWhenPause);
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

    public void nextSong() {
        mMediaPlayer.stop();
        mMediaPlayer.release();
        position++;
        if (position < listSongs.size()) {
            mMediaPlayer = MediaPlayer.create(this, listSongs.get(position));
        } else {
            position = 0;
            mMediaPlayer = MediaPlayer.create(this, listSongs.get(position));
        }
        mMediaPlayer.start();
    }

    public void previousSong() {
        mMediaPlayer.stop();
        mMediaPlayer.release();
        position--;
        if (position >= 0) {
            mMediaPlayer = MediaPlayer.create(this, listSongs.get(position));
        } else {
            position = listSongs.size() - 1;
            mMediaPlayer = MediaPlayer.create(this, listSongs.get(position));
        }
        mMediaPlayer.start();
    }

    public void seekTo(int currentDuration) {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.seekTo(currentDuration);
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mMediaPlayer;
    }
}
