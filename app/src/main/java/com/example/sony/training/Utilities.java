package com.example.sony.training;

/**
 * Created by ThanhThang on 15/11/2017.
 */

public class Utilities {
    public String milliSecondsToTimer(long milliSeconds) {
        String finalTimerString = "";
        String secondsString = "";

        //Chuyen doi thoi gian sang dinh dang hh:mm:ss
        int hours = (int) (milliSeconds / (1000 * 60 * 60));
        int minutes = (int) (milliSeconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) (milliSeconds % (1000 * 60 * 60)) % (1000 * 60) / 1000;

        //Them so 0 vao neu giay co 1 chu so
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }
        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        return finalTimerString;
    }

    public int getProgressPercentage(long currentDuration, long totalDuration) {
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        //tinh ti le %
        percentage = (((double) currentSeconds) / totalSeconds) * 1000;

        return percentage.intValue();
    }

    public int progressToTimer(int progress, int totalDuration) {
        int currentDuration = 0;
        totalDuration = (totalDuration / 1000);
        currentDuration = (int) ((((double) progress) / 100) * totalDuration);

        return currentDuration * 1000;
    }
}
