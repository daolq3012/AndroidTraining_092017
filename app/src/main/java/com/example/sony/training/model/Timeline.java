package com.example.sony.training.model;

/**
 * Created by Admin on 11/06/17.
 */

public class Timeline {
    private int androidImages;
    private String nameVersion;
    private String time;

    public Timeline() {
    }

    public Timeline(int androidImages, String nameVersion, String time) {
        this.androidImages = androidImages;
        this.nameVersion = nameVersion;
        this.time = time;
    }

    public int getAndroidImages() {
        return androidImages;
    }

    public void setAndroidImages(int androidImages) {
        this.androidImages = androidImages;
    }

    public String getNameVersion() {
        return nameVersion;
    }

    public void setNameVersion(String nameVersion) {
        this.nameVersion = nameVersion;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
