package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.asynctask.InsertAsyncTask;
import com.example.sony.training.roomdb.database.Database;
import com.example.sony.training.roomdb.entity.User;

public class InsertUserActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEdtUserName, mEdtAge;
    private Button mBtnOk;
    private Database mDatabase;
    private MainApplication mApplication;
    private InsertAsyncTask mInsertAsyncTask;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);
        initViews();

        initListeners();
    }

    private void initViews() {
        mBtnOk = findViewById(R.id.okButton);
        mEdtAge = findViewById(R.id.ageEdittext);
        mEdtUserName = findViewById(R.id.userNameEdittext);
        mApplication = (MainApplication) getApplication();
        mDatabase = mApplication.getDatabase();
        mInsertAsyncTask = new InsertAsyncTask(this);
    }

    private void initListeners() {
        mBtnOk.setOnClickListener(this);
    }

    private void insertUserIntoDB(){
        String username = mEdtUserName.getText().toString();
        int age = Integer.parseInt(mEdtAge.getText().toString());
        mUser = new User(username, age);
//        mDatabase.getUserDAO().insertUser(new User(username, age));
//        Toast.makeText(this, "Insert Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okButton:
                insertUserIntoDB();
                mInsertAsyncTask.execute(mUser);
                finish();
                break;
        }
    }
}
