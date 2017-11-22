package com.example.sony.training.screen.detailuser;

import com.example.sony.training.data.service.config.GithubApi;

/**
 * Created by Administrator on 11/22/17.
 */

public interface DetailUserContract {

    interface View{

        String getUsername();

        void setUsernameTextView(String name);

        void setUrlTextView(String url);

        void setImage(String strImage);
    }

    interface Presenter{
        void setView(DetailUserContract.View view);

        void setApi(GithubApi api);
    }

}
