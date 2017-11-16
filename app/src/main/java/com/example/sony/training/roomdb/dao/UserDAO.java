package com.example.sony.training.roomdb.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.sony.training.roomdb.entity.User;
import java.util.List;

/**
 * Created by Administrator on 11/16/17.
 */

@Dao
public interface UserDAO{

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users")
    List<User> getListUser();

    @Query("SELECT * FROM users WHERE id = :id")
    User getUserWithID(int id);
}
