package com.example.sony.training.screen.main;


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
