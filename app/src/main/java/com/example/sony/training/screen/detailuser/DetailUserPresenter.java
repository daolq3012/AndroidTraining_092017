package com.example.sony.training.screen.detailuser;

import com.bumptech.glide.Glide;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.constant.Constant;
import com.example.sony.training.data.service.config.GithubApi;
import com.example.sony.training.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 11/22/17.
 */

public class DetailUserPresenter implements DetailUserContract.Presenter {

    private DetailUserContract.View mView;
    private GithubApi mApi;

    @Override
    public void setView(DetailUserContract.View view) {
        mView = view;
    }

    @Override
    public void setApi(GithubApi api) {
        mApi = api;
    }

    public void getDataFromInternet() {
        String username = mView.getUsername();
        GithubApi api = MainApplication.getGithubApi();
        api.getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                String name = response.body().getLogin();
                String url = response.body().getUrl();
                String strImage = response.body().getAvatarUrl();
                mView.setUsernameTextView(name);
                mView.setUrlTextView(url);
                mView.setImage(strImage);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
