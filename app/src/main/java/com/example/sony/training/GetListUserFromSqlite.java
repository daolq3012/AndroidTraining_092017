package com.example.sony.training;

import android.os.AsyncTask;
import com.example.sony.training.database.AndroidTrainingDatabase;
import com.example.sony.training.database.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/16/17.
 */

public class GetListUserFromSqlite extends AsyncTask<Void,Void,List<UserEntity>> {

    private AndroidTrainingDatabase mDatabase;
    private OnGetDataListener mOnGetDataListener;

    public GetListUserFromSqlite(AndroidTrainingDatabase database,
            OnGetDataListener onGetDataListener) {
        mDatabase = database;
        mOnGetDataListener = onGetDataListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<UserEntity> doInBackground(Void... voids) {
        List<UserEntity> listUserEntities = new ArrayList<>();
        listUserEntities = mDatabase.getUserDAO().getAllUsers();
        return listUserEntities;
    }
    @Override
    protected void onPostExecute(List<UserEntity> userEntities) {
        super.onPostExecute(userEntities);
        mOnGetDataListener.onGetDataSuccess(userEntities);
    }
}
