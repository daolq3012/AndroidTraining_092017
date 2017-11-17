package com.example.sony.training.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ThanhThang on 16/11/2017.
 */

@Entity(tableName = "user")
public class UserEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int mID;
    @ColumnInfo(name = "user_name")
    private String mUserName;
    @ColumnInfo(name = "age")
    private int mAge;

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }
}
