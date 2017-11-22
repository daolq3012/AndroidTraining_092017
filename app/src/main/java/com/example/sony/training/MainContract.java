package com.example.sony.training;

import com.example.sony.training.data.ApiService;

/**
 * Created by Admin on 11/22/17.
 */

public interface MainContract {

    interface View {

        String getUsername();

        String getPassword();

        void showToastLoginSuccess();

        void showToastLoginFail(String message);
    }

    interface Presenter {

        void setView(MainContract.View view);

        void setApiService(ApiService apiService);

        void login();
    }
}
