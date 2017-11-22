package com.example.sony.training.application;

import android.app.Application;
import com.example.sony.training.data.service.config.GithubApi;
import com.example.sony.training.data.service.config.ServiceGenerators;

/**
 * Created by Administrator on 11/17/17.
 */

public class MainApplication extends Application {

    private static GithubApi mGithubApi;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mGithubApi == null){
            mGithubApi = ServiceGenerators.createApiService(this);
        }
    }

    public static GithubApi getGithubApi(){
        return mGithubApi;
    }
}
