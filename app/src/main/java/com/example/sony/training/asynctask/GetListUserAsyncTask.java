package com.example.sony.training.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.roomdb.database.Database;
import com.example.sony.training.roomdb.entity.User;
import java.util.List;

/**
 * Created by Administrator on 11/16/17.
 */

public class GetListUserAsyncTask extends AsyncTask<Void,Void,List<User>> {

    private Database mDatabase;
    private MainApplication mApplication;
    private Activity mContext ;

    public GetListUserAsyncTask(Activity context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mApplication = (MainApplication) mContext.getApplication();
        mDatabase = mApplication.getDatabase();
    }

    @Override
    protected List<User> doInBackground(Void... voids) {
        return mDatabase.getUserDAO().getListUser();
    }

    @Override
    protected void onPostExecute(List<User> users) {
        super.onPostExecute(users);
    }
}
