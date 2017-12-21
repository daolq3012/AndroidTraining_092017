package com.example.sony.training.screen.main;

/**
 * Created by Admin on 11/22/17.
 */

public interface MainContract {

    interface View {
        String getKeyword();
        String getLimit();

        void showEmptyMessage(String message);

        void openListUserActivity(String keyword, String limit);
    }

    interface Presenter {
        void setView(MainContract.View view);
        void getInput();
    }
}

