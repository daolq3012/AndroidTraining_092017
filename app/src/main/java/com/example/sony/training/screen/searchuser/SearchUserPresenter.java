package com.example.sony.training.screen.searchuser;


import com.example.sony.training.data.config.GithubApi;

/**
 * Created by ThanhThang on 22/11/2017.
 */

public class SearchUserPresenter implements SearchUserContract.Presenter {

    private SearchUserContract.View mView;
    private GithubApi mGithubApi;

    @Override
    public void setView(SearchUserContract.View view) {
        mView = view;
    }

    @Override
    public void setGithubApi(GithubApi githubApi) {
    mGithubApi = githubApi;
    }

    @Override
    public void search() {
        String keyword = mView.getKeyword();
        int limit = mView.getLimit();

        if (keyword.isEmpty()){
            mView.showToastSearchFail("Please input KeyWord!");
            return;
        }

        mView.onValidateKeyWordLimitSuccess(keyword,limit);

    }
}
