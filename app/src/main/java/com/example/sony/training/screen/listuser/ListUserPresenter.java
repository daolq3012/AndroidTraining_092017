package com.example.sony.training.screen.listuser;

import com.example.sony.training.data.config.GithubApi;
import com.example.sony.training.data.response.SearchGitHubUsersResponse;
import com.example.sony.training.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ThanhThang on 23/11/2017.
 */

public class ListUserPresenter implements ListUserContract.Presenter {

    private ListUserContract.View mView;
    private GithubApi mGithubApi;

    @Override
    public void setView(ListUserContract.View view) {
        mView = view;
    }

    @Override
    public void setGithubApi(GithubApi githubApi) {
        mGithubApi = githubApi;
    }

    @Override
    public void getListUser() {
        String keyword = mView.getKeyword();
        int limit = mView.getLinmit();

        mGithubApi.searchUserGitHub(limit, keyword).enqueue(new Callback<SearchGitHubUsersResponse>() {
            @Override
            public void onResponse(Call<SearchGitHubUsersResponse> call, Response<SearchGitHubUsersResponse> response) {
                List<User> mUser = response.body().getItems();
                mView.setData(mUser);
            }

            @Override
            public void onFailure(Call<SearchGitHubUsersResponse> call, Throwable t) {

            }
        });
    }
}
