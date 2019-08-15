package com.example.sony.training.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 11/15/17.
 */

@Entity(tableName = "users")
public class UserEntity implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "age")
    private int age;

    public UserEntity() {
    }

    protected UserEntity(Parcel in) {
        mId = in.readInt();
        userName = in.readString();
        age = in.readInt();
    }

    public static final Creator<UserEntity> CREATOR = new Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel in) {
            return new UserEntity(in);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(userName);
        parcel.writeInt(age);
    }
}
