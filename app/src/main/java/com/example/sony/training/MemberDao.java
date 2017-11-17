package com.example.sony.training;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by phong on 11/17/17.
 */

@Dao
public interface MemberDao {

    @Query("SELECT * FROM member")
    List<Member> getAllMembers();

    @Insert
    void insertAll(Member... members);
}
