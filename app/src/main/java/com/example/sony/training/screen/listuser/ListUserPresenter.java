package com.example.sony.training.screen.listuser;

import com.example.sony.training.application.MainApplication;
import com.example.sony.training.data.service.config.GithubApi;
import com.example.sony.training.data.service.response.SearchGithubUserResponse;
import com.example.sony.training.model.User;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 11/22/17.
 */

public class ListUserPresenter implements ListUserContract.Presenter{

    private ListUserContract.View mView;
    private GithubApi mApi;
    private List<User> mUsers;
    private static final String TAG = "ListUserPresenter";

    public void setView(ListUserContract.View view){
        mView = view;
    }

    public void setApi(GithubApi api) {
        mApi = api;
    }

    public void getDataFromInternet() {
        String username = mView.getUsername();
        int limit = mView.getLimit();
        mUsers = new ArrayList<>();
        mApi = MainApplication.getGithubApi();
        mApi.seacrhGithubUser(limit, username).enqueue(new Callback<SearchGithubUserResponse>() {
            @Override
            public void onResponse(Call<SearchGithubUserResponse> call,
                    Response<SearchGithubUserResponse> response) {
                mUsers = response.body().getItems();
                mView.receiveData(mUsers);
            }

            @Override
            public void onFailure(Call<SearchGithubUserResponse> call, Throwable t) {
                mView.showToastFail("No Data");
            }
        });
    }
}
