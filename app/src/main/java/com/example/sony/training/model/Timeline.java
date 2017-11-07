package com.example.sony.training.model;

/**
 * Created by Admin on 11/06/17.
 */

public class Timeline {
    private int avatar;
    private String content;
    private String time;

    public Timeline() {
    }

    public Timeline(int avatar, String content, String time) {
        this.avatar = avatar;
        this.content = content;
        this.time = time;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
