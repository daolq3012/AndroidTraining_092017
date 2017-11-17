package com.example.sony.training;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.sony.training.dao.UserDAO;
import com.example.sony.training.entity.UserEntity;

/**
 * Created by ThanhThang on 16/11/2017.
 */

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DB_NAME = "user.db";

    public abstract UserDAO getUserDAO();

    public static final UserDatabase initDatabase(Context context){
        return Room.databaseBuilder(context, UserDatabase.class, DB_NAME).build();
    }
}
