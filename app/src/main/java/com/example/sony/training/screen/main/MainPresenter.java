package com.example.sony.training.screen.main;

import android.widget.Toast;

/**
 * Created by Admin on 11/22/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void getInput() {
        String keyword = mView.getKeyword();
        String limit = mView.getLimit();
        if(keyword.isEmpty()) {
            mView.showEmptyMessage("Please enter keyword!");
            return;
        }
        if(limit.isEmpty()) {
            mView.showEmptyMessage("Please enter limit!");
            return;
        }
        int limitResult = Integer.valueOf(limit);
        mView.openListUserActivity(keyword,limit);
    }
}
