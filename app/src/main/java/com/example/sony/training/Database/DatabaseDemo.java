package com.example.sony.training.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.sony.training.Database.dao.UserDAO;
import com.example.sony.training.Database.entity.UserEntity;

/**
 * Created by ThanhThang on 15/11/2017.
 */

@Database(entities = {UserEntity.class}, version = 1)
public abstract class DatabaseDemo extends RoomDatabase{

    private static final String DB_NAME = "android_training.db";

    public abstract UserDAO getUserDAO();

    public static final DatabaseDemo initDatabase(Context context){
        return Room.databaseBuilder(context, DatabaseDemo.class, DB_NAME).allowMainThreadQueries().build();
    }
}
