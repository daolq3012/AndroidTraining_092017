package com.example.sony.training.screen.listuser;

import com.example.sony.training.model.User;
import com.example.sony.training.data.service.config.GitHubApi;
import com.example.sony.training.data.service.response.SearchGithubUserResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 11/22/17.
 */

public class ListUserPresenter implements ListUserContract.Presenter {

    private ListUserContract.View mView;
    private GitHubApi mGitHubApi;

    @Override
    public void setView(ListUserContract.View view) {
        mView = view;
    }

    @Override
    public void setGitHubApi(GitHubApi gitHubApi) {
        mGitHubApi = gitHubApi;
    }

    @Override
    public void getListGithubUser() {

        String keyword = mView.getKeyword();
        int limit = mView.getLimit();

        mGitHubApi.searchUserGithub(limit,keyword).enqueue(new Callback<SearchGithubUserResponse>() {
            @Override
            public void onResponse(Call<SearchGithubUserResponse> call,
                    Response<SearchGithubUserResponse> response) {
                List<User> listItems = response.body().getItems();
                mView.retrieveData(listItems);
            }

            @Override
            public void onFailure(Call<SearchGithubUserResponse> call, Throwable t) {

            }
        });
    }
}
