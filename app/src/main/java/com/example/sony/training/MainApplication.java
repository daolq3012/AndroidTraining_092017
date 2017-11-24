package com.example.sony.training;

import android.app.Application;

import com.example.sony.training.data.config.GithubApi;
import com.example.sony.training.data.config.ServiceGenerators;

/**
 * Created by ThanhThang on 22/11/2017.
 */

public class MainApplication extends Application {
    private static GithubApi mGithubApi;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mGithubApi == null) {
            mGithubApi = ServiceGenerators.createApiService(this);
        }
    }

    public static GithubApi getmGithubApi() {
        return mGithubApi;
    }
}
