package com.example.sony.training;

import android.app.Application;

import com.example.sony.training.services.config.GitHubApi;
import com.example.sony.training.services.config.ServiceGenerators;

/**
 * Created by ThanhThang on 17/11/2017.
 */

public class MainApplication extends Application {
    private static GitHubApi mGithubApi;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mGithubApi == null) {
            mGithubApi = ServiceGenerators.createApiService(this);
        }
    }

    public static GitHubApi getmGithubApi() {
        return mGithubApi;
    }
}
