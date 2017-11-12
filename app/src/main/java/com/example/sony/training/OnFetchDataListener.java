package com.example.sony.training;

import java.util.List;

/**
 * Created by Administrator on 11/08/17.
 */
// cau noi giua background voi main thread
public interface OnFetchDataListener {
    void onFetchDataSuccess(List<Item> users);
}
