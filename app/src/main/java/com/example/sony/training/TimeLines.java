package com.example.sony.training;

/**
 * Created by ThanhThang on 07/11/2017.
 */

public class TimeLines {
    private String mImage;
    private String mName;

    public TimeLines(){

    }
    public TimeLines(String Image, String Name){
        this.mImage = Image;
        this.mName = Name;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
