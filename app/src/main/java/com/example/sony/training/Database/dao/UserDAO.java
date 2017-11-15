package com.example.sony.training.Database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.sony.training.Database.entity.UserEntity;

import java.util.List;

/**
 * Created by ThanhThang on 15/11/2017.
 */

@Dao
public interface UserDAO {

    @Insert
    void insertUser(UserEntity userEntity);

    @Query("SELECT * FROM users")
    List<UserEntity> getAllUser();

    @Query("SELECT * FROM users WHERE id = :id")
    UserEntity getUserWithID(int id);
}
