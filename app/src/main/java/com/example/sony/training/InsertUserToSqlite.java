package com.example.sony.training;

import android.content.Context;
import android.os.AsyncTask;
import com.example.sony.training.database.AndroidTrainingDatabase;
import com.example.sony.training.database.entity.UserEntity;

/**
 * Created by Admin on 11/16/17.
 */

public class InsertUserToSqlite extends AsyncTask<UserEntity,Void,Void> {

    private AndroidTrainingDatabase mDatabase;
    private OnInsertDataListener mOnInsertDataListener;

    public InsertUserToSqlite(AndroidTrainingDatabase database, OnInsertDataListener onInsertDataListener) {
        mDatabase = database;
        mOnInsertDataListener = onInsertDataListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(UserEntity... userEntities) {
        mDatabase.getUserDAO().insertUser(userEntities[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mOnInsertDataListener.onInsertDataSuccess();
    }
}
