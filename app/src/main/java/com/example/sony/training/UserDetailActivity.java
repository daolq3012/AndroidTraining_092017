package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.sony.training.database.entity.UserEntity;

public class UserDetailActivity extends AppCompatActivity {

    private TextView mTxtId, mTxtUsername, mTxtAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        UserEntity user = getIntent().getParcelableExtra(Constant.EXTRA_USER);

        initViews();

        mTxtId.setText("ID: "+String.valueOf(user.getId()));
        mTxtUsername.setText("Username: "+user.getUserName());
        mTxtAge.setText("Age: "+user.getAge());

    }

    private void initViews() {
        mTxtId = findViewById(R.id.txtIdDetail);
        mTxtUsername = findViewById(R.id.txtUsernameDetail);
        mTxtAge = findViewById(R.id.txtAgeDetail);
    }
}
