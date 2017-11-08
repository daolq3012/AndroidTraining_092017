package com.example.sony.training.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/08/17.
 */

public class UserProfile {
    private int cover;
    private int avatar;
    private String name;
    private String bio;

    public UserProfile() {
    }

    public UserProfile(int cover, int avatar, String name, String bio) {
        this.cover = cover;
        this.avatar = avatar;
        this.name = name;
        this.bio = bio;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
