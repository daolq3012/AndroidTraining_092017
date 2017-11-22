package com.example.sony.training.screen.main;

import android.content.Intent;
import com.example.sony.training.constant.Constant;
import com.example.sony.training.screen.listuser.ListUserActivity;

/**
 * Created by Administrator on 11/22/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    public void getDataFromView() {
        String username = mView.getUsername();
        int limit = mView.getLimit();
        mView.moveToListUserActivity(username, limit);
    }
}
