package com.example.sony.training;

import android.widget.Toast;
import com.example.sony.training.data.ApiService;

/**
 * Created by Administrator on 11/22/17.
 */

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;
    private ApiService apiService;

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void login() {
        String username = view.getUsername();
        String password = view.getPassword();
        boolean isLoginSuccess = this.apiService.login(username, password);

        if (username.isEmpty() || password.isEmpty()){
            view.showToastLoginFail("Please input username or password!");
            return;
        }

        if (isLoginSuccess){
            view.showToastLoginSuccess();
        } else {
            view.showToastLoginFail("Username or Password InCorrect!");
        }
    }
}
