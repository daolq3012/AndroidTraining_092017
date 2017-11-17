package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.sony.training.database.AndroidTrainingDatabase;
import com.example.sony.training.database.entity.UserEntity;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AndroidTrainingDatabase mDatabase;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication application = (MainApplication) getApplication();
        mDatabase = application.getDatabase();
    }

    public void OnInsertButtonClick(View view) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(new Random().nextInt());
        userEntity.setAge(new Random().nextInt());
        userEntity.setUserName("ABC");
        mDatabase.getUserDAO().insertUser(userEntity);
    }

    public void OnGetAllUserButtonClick(View view) {
        List<UserEntity> entityList = mDatabase.getUserDAO().getAllUser();
        Log.d(TAG, "OnGetAllUserButtonClick: " + entityList.get(0).getUserName() + entityList.get(0).getAge());
    }
}
