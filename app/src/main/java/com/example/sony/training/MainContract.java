package com.example.sony.training;

import com.example.sony.training.data.ApiService;

/**
 * Created by ThanhThang on 22/11/2017.
 */

public interface MainContract {
    interface View{

        String getUserName();

        String getPassword();

        void showToastLoginSuccess();

        void showToastLoginFail(String s);
    }
    interface Presenter{
        void setView(MainContract.View view);
        void setApiService(ApiService apiService);

        void login();
    }
}
