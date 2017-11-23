package com.example.sony.training;

import android.app.Application;

/**
 * Created by phong on 11/18/17.
 */

public class MainApplication extends Application {

    private static GitHubApi mGitHubApi;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mGitHubApi == null){
            mGitHubApi = ServiceGenerators.createApiService(this);
        }
    }

    public static GitHubApi getGithubApi(){
        return mGitHubApi;
    }
}
