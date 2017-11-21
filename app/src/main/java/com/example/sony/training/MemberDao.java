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

    @Insert
    void insertMember(Member member);

    @Query("SELECT * FROM members")
    List<Member> getListMember();

    @Query("SELECT * FROM members WHERE id = :id")
    Member getMemberWithID(int id);
}
