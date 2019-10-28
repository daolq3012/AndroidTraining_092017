package com.example.sony.training.screen.listuser;

import android.view.View;
import com.example.sony.training.data.service.config.GithubApi;
import com.example.sony.training.model.User;
import java.util.List;

/**
 * Created by Administrator on 11/22/17.
 */

public interface ListUserContract {
     interface View{

         String getUsername();

         int getLimit();

         void receiveData(List<User> users);

         void showToastFail(String message);
     }

     interface Presenter{

        void setView(ListUserContract.View view);

        void setApi(GithubApi api);
     }
}
