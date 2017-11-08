package com.example.sony.training;

import com.example.sony.training.model.User;
import java.util.List;

/**
 * Created by daolq on 11/8/17.
 */

public interface OnFetchDataListener {
    void onFetchDataSuccess(List<User> users);
}
