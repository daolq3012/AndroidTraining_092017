package com.example.sony.training.screen.detailuser;

import com.example.sony.training.data.config.GithubApi;
import com.example.sony.training.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ThanhThang on 23/11/2017.
 */

public class DetailUserPresenter implements DetailUserContract.Presenter {
    private DetailUserContract.View mView;
    private GithubApi mGithub;

    @Override
    public void setView(DetailUserContract.View view) {
        mView = view;
    }

    @Override
    public void setGithubApi(GithubApi githubApi) {
        mGithub = githubApi;
    }

    @Override
    public void getUserDetail() {
        String name = mView.getUserName();

        mGithub.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                String name = response.body().getLogin();
                String img = response.body().getAvatarUrl();
                mView.setUserName(name, img);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
