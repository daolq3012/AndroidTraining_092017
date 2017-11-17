package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sony.training.entity.UserEntity;

import java.util.concurrent.ExecutionException;

public class UserDetailActivity extends AppCompatActivity {

    private TextView nameDetailTextView, ageDetailTextView;
    private UserDatabase mUserDatabase;
    private MainApplication mMainApplication;
    private SelectListUserFromDatabase mSelectListUserFromDatabase;
    private UserEntity mUserEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        initViews();

        nameDetailTextView.setText(mUserEntity.getUserName());
        ageDetailTextView.setText(mUserEntity.getAge());
    }

    private void initViews() {
        nameDetailTextView = findViewById(R.id.nameDetailTextView);
        ageDetailTextView = findViewById(R.id.ageDetailTextView);
        mMainApplication = (MainApplication) getApplication();
        mUserDatabase = mMainApplication.getUserDatabase();
        mSelectListUserFromDatabase = new SelectListUserFromDatabase(this);
        mSelectListUserFromDatabase.execute();
        getUser();
    }

    private UserEntity getUser() {
        try {
            mUserEntity = (UserEntity) mSelectListUserFromDatabase.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return mUserEntity;
    }
}
