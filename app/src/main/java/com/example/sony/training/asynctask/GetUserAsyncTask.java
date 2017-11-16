package com.example.sony.training.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.roomdb.database.Database;
import com.example.sony.training.roomdb.entity.User;

/**
 * Created by Administrator on 11/16/17.
 */

public class GetUserAsyncTask extends AsyncTask<Integer, Void, User> {

    private Database mDatabase;
    private MainApplication mApplication;
    private Activity mContext ;

    public GetUserAsyncTask(Activity context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mApplication = (MainApplication) mContext.getApplication();
        mDatabase = mApplication.getDatabase();
    }

    @Override
    protected User doInBackground(Integer... integers) {
        int id = integers[0];
        return mDatabase.getUserDAO().getUserWithID(id);
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
    }
}
