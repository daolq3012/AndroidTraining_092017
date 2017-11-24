package com.example.sony.training.screen.searchuser;

import com.example.sony.training.data.config.GithubApi;

/**
 * Created by ThanhThang on 22/11/2017.
 */

public interface SearchUserContract {
    interface View {
        String getKeyword();
        int getLimit();
        void showToastSearchFail(String s);

        void onValidateKeyWordLimitSuccess(String keyword, int limit);
    }

    interface Presenter{
        void setView(SearchUserContract.View view);
        void setGithubApi(GithubApi githubApi);

        void search();
    }
}
