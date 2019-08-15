package com.example.sony.training;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.sony.training.database.AndroidTrainingDatabase;
import com.example.sony.training.database.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnGetDataListener {

    private AndroidTrainingDatabase mDatabase;
    private Button mBtnInsert;
    private Button mBtnGetAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication applicaton = (MainApplication) getApplication();
        mDatabase = applicaton.getDatabase();

        initViews();
        initEvents();
    }

    private void initEvents() {
        mBtnInsert.setOnClickListener(this);
        mBtnGetAll.setOnClickListener(this);
    }

    private void initViews() {
        mBtnInsert = findViewById(R.id.insertButton);
        mBtnGetAll = findViewById(R.id.getAllButton);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insertButton:
                Intent intent = new Intent(this,InsertUserActivity.class);
                startActivity(intent);
                break;
            case R.id.getAllButton:
                new GetListUserFromSqlite(mDatabase,this).execute();
                break;
        }
    }

    @Override
    public void onGetDataSuccess(List<UserEntity> listUserEntities) {
        ArrayList<UserEntity> listItems = (ArrayList<UserEntity>) listUserEntities;
        Intent intent = new Intent(this,ListUserActivity.class);
        intent.putParcelableArrayListExtra(Constant.EXTRA_USER_LIST,listItems);
        startActivity(intent);
    }
}
