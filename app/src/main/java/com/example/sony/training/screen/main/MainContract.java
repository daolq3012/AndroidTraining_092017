package com.example.sony.training.screen.main;

/**
 * Created by Administrator on 11/22/17.
 */

public interface MainContract {

    interface View{

        String getUsername();

        int getLimit();

        void moveToListUserActivity(String username, int limit);
    }

    interface Presenter{
        void setView(MainContract.View view);
    }

}
