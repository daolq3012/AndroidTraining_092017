package com.example.sony.training;

import com.example.sony.training.database.entity.UserEntity;
import java.util.List;

/**
 * Created by Admin on 11/16/17.
 */

public interface OnGetDataListener {
    void onGetDataSuccess(List<UserEntity> listUserEntities);
}
