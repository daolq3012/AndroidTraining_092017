package com.example.sony.training.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.roomdb.database.Database;
import com.example.sony.training.roomdb.entity.User;

/**
 * Created by Administrator on 11/16/17.
 */

public class InsertAsyncTask extends AsyncTask<User, Void, Void> {
    private Database mDatabase;
    private MainApplication mApplication;
    private Activity mContext ;

    public InsertAsyncTask(Activity context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(User... users) {
        User user = users[0];
        insertUserIntoDB(user);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mApplication = (MainApplication) mContext.getApplication();
        mDatabase = mApplication.getDatabase();
    }

    private void insertUserIntoDB(User user){
        mDatabase.getUserDAO().insertUser(user);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mContext, "thanh cong", Toast.LENGTH_SHORT).show();
    }
}
