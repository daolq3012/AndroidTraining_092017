package com.example.sony.training.roomdb.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.sony.training.roomdb.dao.UserDAO;
import com.example.sony.training.roomdb.entity.User;

/**
 * Created by Administrator on 11/16/17.
 */

@android.arch.persistence.room.Database(entities = {User.class}, version = 1)
public abstract class Database extends RoomDatabase{
    private static final String DB_NAME = "buoi11.db";
    public abstract UserDAO getUserDAO();
    public static final Database initDatabase(Context context){
        return Room.databaseBuilder(context, Database.class, DB_NAME).build();
    }
}
