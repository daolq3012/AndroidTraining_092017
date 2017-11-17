package com.example.sony.training;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by phong on 11/17/17.
 */

@Database(entities = {Member.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MemberDao memberDao();
}
