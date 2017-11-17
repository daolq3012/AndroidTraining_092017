package com.example.sony.training.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.sony.training.entity.UserEntity;

import java.util.List;

/**
 * Created by ThanhThang on 16/11/2017.
 */
@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertUser(UserEntity userEntity);

    @Query("SELECT * FROM user")
    List<UserEntity> getAllUser();

}
