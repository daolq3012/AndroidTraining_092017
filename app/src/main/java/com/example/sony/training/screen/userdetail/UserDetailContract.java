package com.example.sony.training.screen.userdetail;

import com.example.sony.training.data.service.config.GitHubApi;

/**
 * Created by Admin on 11/22/17.
 */

public interface UserDetailContract {

    interface View {

        String getUsername();

        void updateUserDetail(String avatarUrl, String login, String htmlUrl);
    }

    interface Presenter {

        void setView(UserDetailContract.View view);

        void setGithubApi(GitHubApi gitHubApi);

        void getUserDetail();
    }

}
