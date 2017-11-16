package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.asynctask.GetListUserAsyncTask;
import com.example.sony.training.asynctask.InsertAsyncTask;
import com.example.sony.training.roomdb.database.Database;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnInsert, mBtnGetAllList;
    private MainApplication mApplication;
    private GetListUserAsyncTask mGetListUserAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews() {
        mBtnInsert = findViewById(R.id.insertButton);
        mBtnGetAllList = findViewById(R.id.getAllListButton);
    }

    private void initListeners() {
        mBtnInsert.setOnClickListener(this);
        mBtnGetAllList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertButton:
                startActivity(new Intent(this, InsertUserActivity.class));
                break;
            case R.id.getAllListButton:
                startActivity(new Intent(this, ListUserActivity.class));
                break;
        }
    }
}
