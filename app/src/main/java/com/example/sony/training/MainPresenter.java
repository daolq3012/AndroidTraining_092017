package com.example.sony.training;

import com.example.sony.training.data.ApiService;

/**
 * Created by ThanhThang on 22/11/2017.
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
        mApiService= apiService;
    }

    @Override
    public void login() {
        String username = mView.getUserName();
        String password = mView.getPassword();

        if (username.isEmpty()){
            mView.showToastLoginFail("Please input User Name!");
            return;
        }

        if (password.isEmpty()){
            mView.showToastLoginFail("Please input Password!");
            return;
        }

        boolean isLoginSuccess = mApiService.login(username, password);
        if (isLoginSuccess){
            mView.showToastLoginSuccess();
        } else {
            mView.showToastLoginFail("UserName or Password InCorrect!");
        }
    }
}
