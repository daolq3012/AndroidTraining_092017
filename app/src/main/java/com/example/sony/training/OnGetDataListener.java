package com.example.sony.training;

import com.example.sony.training.entity.UserEntity;

import java.util.List;

/**
 * Created by ThanhThang on 17/11/2017.
 */

public interface OnGetDataListener {
    void OnGetDataSuccess(List<UserEntity> userEntities);
}
