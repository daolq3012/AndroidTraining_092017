package com.example.sony.training.screen.listuser;

import com.example.sony.training.model.User;
import com.example.sony.training.data.service.config.GitHubApi;
import java.util.List;

/**
 * Created by Admin on 11/22/17.
 */

public interface ListUserContract {

    interface View {

        void retrieveData(List<User> listItems);

        String getKeyword();

        int getLimit();
    }

    interface Presenter {
        void setView(ListUserContract.View view);

        void setGitHubApi(GitHubApi gitHubApi);

        void getListGithubUser();
    }

}
