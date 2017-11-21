package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MemberDetailActivity extends AppCompatActivity {
    private TextView mId, mName, mAge;
    private AppDatabase mDatabase;
    private MainApplication mApplication;
    private GetMemberAsyncTask mGetMemberAsyncTask;
    private Member mMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

        initviews();
        mId.setText(mMember.getId());
        mName.setText(mMember.getName());
        mAge.setText(mMember.getAge());
    }

    private void initviews() {
        mId = findViewById(R.id.idDetailTextView);
        mName = findViewById(R.id.nameDetailTextView);
        mAge = findViewById(R.id.ageDetailTextView);
        mApplication = (MainApplication) getApplication();
        mDatabase = mApplication.getDatabase();
        mGetMemberAsyncTask = new GetMemberAsyncTask(this);
        int id = getIntent().getIntExtra(Constant.ID_MEMBER, 0);
        mGetMemberAsyncTask.execute(id+1);
        getMember();
    }
    private Member getMember(){
        try {
            mMember = mGetMemberAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return mMember;
    }
}
