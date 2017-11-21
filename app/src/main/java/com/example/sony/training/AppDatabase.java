package com.example.sony.training;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by phong on 11/17/17.
 */

@android.arch.persistence.room.Database(entities = {Member.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static final String DB_NAME = "members.db";
    public abstract MemberDao memberDao();
    public static final AppDatabase initDatabase(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }
}
