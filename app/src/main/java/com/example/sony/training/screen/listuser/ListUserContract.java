package com.example.sony.training.screen.listuser;

import com.example.sony.training.data.config.GithubApi;
import com.example.sony.training.model.User;

import java.util.List;

/**
 * Created by ThanhThang on 23/11/2017.
 */

public interface ListUserContract {
    interface View {
        void setData(List<User> users);
        String getKeyword();
        int getLinmit();
    }

    interface Presenter {
        void setView (ListUserContract.View view);
        void setGithubApi(GithubApi githubApi);
        void getListUser();
    }
}
