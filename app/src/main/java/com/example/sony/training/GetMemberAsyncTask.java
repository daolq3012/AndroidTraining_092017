package com.example.sony.training;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * Created by phong on 11/22/17.
 */

public class GetMemberAsyncTask extends AsyncTask<Integer, Void, Member> {

    private AppDatabase mDatabase;
    private MainApplication mApplication;
    private Activity mContext ;

    public GetMemberAsyncTask(Activity context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mApplication = (MainApplication) mContext.getApplication();
        mDatabase = mApplication.getDatabase();
    }

    @Override
    protected Member doInBackground(Integer... integers) {
        int id = integers[0];
        return mDatabase.memberDao().getMemberWithID(id);
    }

    @Override
    protected void onPostExecute(Member member) {
        super.onPostExecute(member);
    }
}
