package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.asynctask.GetListUserAsyncTask;
import com.example.sony.training.asynctask.GetUserAsyncTask;
import com.example.sony.training.constant.Constant;
import com.example.sony.training.roomdb.database.Database;
import com.example.sony.training.roomdb.entity.User;
import java.util.concurrent.ExecutionException;

public class UserDetailActivity extends AppCompatActivity {

    private TextView mTxtID, mTxtName, mTxtAge;
    private Database mDatabase;
    private MainApplication mApplication;
    private GetUserAsyncTask mGetUserAsyncTask;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        initViews();
        mTxtID.setText(mUser.getId()+"");
        mTxtName.setText(mUser.getUserName());
        mTxtAge.setText(mUser.getAge()+"");
    }

    private void initViews() {
        mTxtAge = findViewById(R.id.ageDetailTextView);
        mTxtName = findViewById(R.id.nameDetailTextView);
        mTxtID = findViewById(R.id.idDetailTextView);
        mApplication = (MainApplication) getApplication();
        mDatabase = mApplication.getDatabase();
        mGetUserAsyncTask = new GetUserAsyncTask(this);
        int id = getIntent().getIntExtra(Constant.ID_USER, 0);
        mGetUserAsyncTask.execute(id+1);
        getUser();
    }
    private User getUser(){
        try {
            mUser = mGetUserAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return mUser;
    }
}
