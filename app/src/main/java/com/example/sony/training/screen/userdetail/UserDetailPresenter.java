package com.example.sony.training.screen.userdetail;

import com.example.sony.training.model.User;
import com.example.sony.training.data.service.config.GitHubApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 11/22/17.
 */

public class UserDetailPresenter implements UserDetailContract.Presenter {

    private UserDetailContract.View mView;
    private GitHubApi mGitHubApi;

    @Override
    public void setView(UserDetailContract.View view) {
        mView = view;
    }

    @Override
    public void setGithubApi(GitHubApi gitHubApi) {
        mGitHubApi = gitHubApi;
    }

    @Override
    public void getUserDetail() {
        String username = mView.getUsername();

        mGitHubApi.getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                String avatarUrl = response.body().getAvatarUrl();
                String login = response.body().getLogin();
                String htmlUrl = response.body().getHtmlUrl();
                mView.updateUserDetail(avatarUrl,login,htmlUrl);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
