package com.example.sony.training.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.example.sony.training.database.entity.UserEntity;
import java.util.List;

/**
 * Created by daolq on 11/15/17.
 */

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserEntity userEntity);

    @Query("SELECT * FROM users")
    List<UserEntity> getAllUsers();

    @Query("SELECT * FROM users WHERE id=:id")
    UserEntity getUserWithId(int id);
}
