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

    private static final String TAG = "MainActivity";

    private AndroidTrainingDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication application = (MainApplication) getApplication();
        mDatabase = application.getDatabase();
    }

    public void onInsertButtonClicked(View view) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(new Random().nextInt());
        userEntity.setUserName("ABC");
        mDatabase.getUserDAO().insertUser(userEntity);
    }

    public void onGetAllButtonClicked(View view) {
        List<UserEntity> userEntities = mDatabase.getUserDAO().getAllUsers();
        Log.d(TAG, "onGetAllButtonClicked: " + userEntities.size());
    }
}
