package com.example.sony.training.screen.detailuser;

import com.example.sony.training.data.config.GithubApi;

/**
 * Created by ThanhThang on 23/11/2017.
 */

public interface DetailUserContract {
    interface View{
        String getUserName();
        void setUserName(String img, String name);
    }

    interface Presenter{
        void setView (DetailUserContract.View view);
        void setGithubApi(GithubApi githubApi);
        void getUserDetail();
    }
}
