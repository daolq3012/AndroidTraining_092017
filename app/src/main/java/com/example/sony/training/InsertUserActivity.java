package com.example.sony.training;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sony.training.database.AndroidTrainingDatabase;
import com.example.sony.training.database.entity.UserEntity;

public class InsertUserActivity extends AppCompatActivity implements View.OnClickListener, OnInsertDataListener {

    private AndroidTrainingDatabase mDatabase;
    private EditText mEdtUsername;
    private EditText mEdtAge;
    private Button mBtnInsertUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        MainApplication application = (MainApplication) getApplication();
        mDatabase = application.getDatabase();

        initViews();
        initEvents();
    }

    private void initViews() {
        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtAge = (EditText) findViewById(R.id.edtAge);
        mBtnInsertUser = (Button) findViewById(R.id.btnInsertUser);
    }

    private void initEvents() {
        mBtnInsertUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInsertUser:
                String username = mEdtUsername.getText().toString();
                int age = Integer.valueOf(mEdtAge.getText().toString());
                UserEntity userEntity = new UserEntity();
                userEntity.setUserName(username);
                userEntity.setAge(age);
                new InsertUserToSqlite(mDatabase,this).execute(userEntity);
                break;
        }
    }

    @Override
    public void onInsertDataSuccess() {
        Toast.makeText(this,"Insert "+mEdtUsername.getText().toString()+" success!",Toast.LENGTH_LONG).show();
    }
}
