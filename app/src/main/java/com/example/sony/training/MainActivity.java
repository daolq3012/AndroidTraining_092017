package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sony.training.Database.DatabaseDemo;
import com.example.sony.training.Database.entity.UserEntity;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "ABC";
    private DatabaseDemo mDatabaseDemo;
    private Button insertBtn, getAllBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertBtn = findViewById(R.id.insertBtn);
        getAllBtn = findViewById(R.id.getAllBtn);

        insertBtn.setOnClickListener(this);
        getAllBtn.setOnClickListener(this);

        MainApplication application = (MainApplication) getApplication();
        mDatabaseDemo = application.getDatabase();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.insertBtn:
                UserEntity userEntity = new UserEntity();
                userEntity.setId(new Random(20).nextInt());
                userEntity.setUserName("ABC");
                mDatabaseDemo.getUserDAO().insertUser(userEntity);
                break;
            case R.id.getAllBtn:
                List<UserEntity> userEntities = mDatabaseDemo.getUserDAO().getAllUser();
                Log.d(TAG, "onGetAllUser: " + userEntities.size());
                break;
        }
    }
}