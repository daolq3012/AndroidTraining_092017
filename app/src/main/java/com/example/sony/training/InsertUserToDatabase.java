package com.example.sony.training;

import android.os.AsyncTask;

import com.example.sony.training.entity.UserEntity;

/**
 * Created by ThanhThang on 17/11/2017.
 */

public class InsertUserToDatabase extends AsyncTask<UserEntity, Void, Void> {

    private UserDatabase mUserDatabase;
    private OnInsertDataListener mOnInsertDataListener;

    public InsertUserToDatabase(UserDatabase database, OnInsertDataListener onInsertDataListener){
        mUserDatabase = database;
        mOnInsertDataListener = onInsertDataListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(UserEntity... userEntities) {
        mUserDatabase.getUserDAO().InsertUser(userEntities[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mOnInsertDataListener.onInsertDataSuccess();
    }
}
