package com.example.sony.training;

/**
 * Created by Administrator on 11/08/17.
 */

public class ItemTimeLine {
    private int image;
    private String status;

    public ItemTimeLine(int image, String status) {
        this.image = image;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
