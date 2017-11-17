package com.example.sony.training;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.sony.training.entity.UserEntity;

import java.util.List;

/**
 * Created by ThanhThang on 17/11/2017.
 */

public class SelectListUserFromDatabase extends AsyncTask<Void, Void, List<UserEntity>>{

    private UserDatabase mUserDataBase;
    private MainApplication mMainApplication;
    private Activity mContext;

    public SelectListUserFromDatabase(Activity context){
        mContext = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mMainApplication = (MainApplication) mContext.getApplication();
        mUserDataBase = mMainApplication.getUserDatabase();
    }

    @Override
    protected List<UserEntity> doInBackground(Void... voids) {
        return mUserDataBase.getUserDAO().getAllUser();
    }

    @Override
    protected void onPostExecute(List<UserEntity> userEntities) {
        super.onPostExecute(userEntities);
    }

}
