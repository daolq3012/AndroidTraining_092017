package com.example.sony.training;

import com.example.sony.training.data.ApiService;

/**
 * Created by Admin on 11/22/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private ApiService mApiService;

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void setApiService(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public void login() {
        String username = mView.getUsername();
        String password = mView.getPassword();

        if (username.isEmpty()) {
            mView.showToastLoginFail("Please input username!");
            return;
        }
        if (password.isEmpty()) {
            mView.showToastLoginFail("Please input password!");
            return;
        }

        boolean isLoginSuccess = mApiService.login(username,password);
        if (isLoginSuccess) {
            mView.showToastLoginSuccess();
        } else {
            mView.showToastLoginFail("Username or Password incorrect!");
        }
    }
}
