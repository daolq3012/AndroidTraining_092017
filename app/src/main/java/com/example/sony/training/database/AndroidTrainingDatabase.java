package com.example.sony.training.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.sony.training.database.dao.UserDAO;
import com.example.sony.training.database.entity.UserEntity;

/**
 * Created by daolq on 11/15/17.
 */

@Database(entities = { UserEntity.class }, version = 1)
public abstract class AndroidTrainingDatabase extends RoomDatabase {

    private static final String DB_NAME = "android_training.db";

    public abstract UserDAO getUserDAO();

    public static final AndroidTrainingDatabase initDatabase(Context context) {
        return Room.databaseBuilder(context, AndroidTrainingDatabase.class, DB_NAME)
                .allowMainThreadQueries().build();
    }
}
