package com.example.sony.training;

import android.app.Application;
import com.example.sony.training.service.config.GitHubApi;
import com.example.sony.training.service.config.ServiceGenerators;

/**
 * Created by Admin on 11/17/17.
 */

public class MainApplication extends Application {
    private static GitHubApi mGitHubApi;

    @Override
    public void onCreate() {
        super.onCreate();
        if(mGitHubApi == null) {
            mGitHubApi = ServiceGenerators.createApiService(this);
        }
    }

    public static GitHubApi getGitHubApi() {
        return  mGitHubApi;
    }
}
