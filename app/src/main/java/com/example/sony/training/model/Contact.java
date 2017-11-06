package com.example.sony.training.model;

public class Contact {
    private int avatar;
    private String name;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(int avatar, String name, String phoneNumber) {
        this.avatar = avatar;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
