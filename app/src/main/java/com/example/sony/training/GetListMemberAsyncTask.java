package com.example.sony.training;

import android.app.Activity;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by phong on 11/21/17.
 */

public class GetListMemberAsyncTask extends AsyncTask<Void,Void,List<Member>> {

    private AppDatabase mDatabase;
    private MainApplication mApplication;
    private Activity mContext ;

    public GetListMemberAsyncTask(Activity context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mApplication = (MainApplication) mContext.getApplication();
        mDatabase = mApplication.getDatabase();
    }

    @Override
    protected List<Member> doInBackground(Void... voids) {
        return mDatabase.memberDao().getListMember();
    }

    @Override
    protected void onPostExecute(List<Member> members) {
        super.onPostExecute(members);
    }
}