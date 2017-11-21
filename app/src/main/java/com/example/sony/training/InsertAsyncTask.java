package com.example.sony.training;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by phong on 11/21/17.
 */

public class InsertAsyncTask extends AsyncTask<Member, Void, Void> {
    private AppDatabase mDatabase;
    private MainApplication mApplication;
    private Activity mContext;

    public InsertAsyncTask(Activity context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(Member... members) {
        Member member = members[0];
        insertMemberIntoDB(member);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mApplication = (MainApplication) mContext.getApplication();
        mDatabase = mApplication.getDatabase();
    }

    private void insertMemberIntoDB(Member member) {
        mDatabase.memberDao().insertMember(member);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mContext, "Complete!", Toast.LENGTH_SHORT).show();
    }
}
