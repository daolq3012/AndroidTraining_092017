package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sony.training.entity.UserEntity;

public class InsertUserActivity extends AppCompatActivity implements View.OnClickListener, OnInsertDataListener {

    private EditText userEditText, ageEditText;
    private Button insertButton;

    private UserDatabase mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);
        MainApplication application = (MainApplication) getApplication();
        mUserDatabase = application.getUserDatabase();

        initViews();
        initEvents();
    }

    private void initEvents() {
        insertButton.setOnClickListener(this);
    }

    private void initViews() {
        userEditText = findViewById(R.id.userEditText);
        ageEditText = findViewById(R.id.ageEditText);
        insertButton = findViewById(R.id.insertButton);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.insertButton:
                insertUser();
                break;
        }
    }

    public void insertUser(){
        String username = userEditText.getText().toString();
        int age = Integer.valueOf(ageEditText.getText().toString());
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(username);
        userEntity.setAge(age);
        new InsertUserToDatabase(mUserDatabase, this).execute(userEntity);
    }

    @Override
    public void onInsertDataSuccess() {
        Toast.makeText(this, "Insert "+ userEditText.getText().toString() + " success!", Toast.LENGTH_SHORT).show();
    }
}
