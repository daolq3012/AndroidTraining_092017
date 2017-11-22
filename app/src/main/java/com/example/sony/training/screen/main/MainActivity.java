package com.example.sony.training.screen.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.sony.training.R;
import com.example.sony.training.constant.Constant;
import com.example.sony.training.screen.detailuser.DetailUserPresenter;
import com.example.sony.training.screen.listuser.ListUserActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private static final String TAG = "MainActivity";
    private Button mBtnSearch;
    private EditText mEdtUserName, mEdtLimit;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mPresenter = new MainPresenter();
        mPresenter.setView(this);

        handleEvents();
    }

    private void handleEvents() {
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getDataFromView();
            }
        });
    }

    private void initViews() {
        mBtnSearch = findViewById(R.id.searchButton);
        mEdtUserName = findViewById(R.id.userNameEdittext);
        mEdtLimit = findViewById(R.id.limitEdittext);
    }

    @Override
    public String getUsername() {
        return mEdtUserName.getText().toString();
    }

    @Override
    public int getLimit() {
        return Integer.parseInt(mEdtLimit.getText().toString());
    }

    @Override
    public void moveToListUserActivity(String username, int limit) {
        startActivity(new Intent(MainActivity.this, ListUserActivity.class).putExtra(
                Constant.USERNAME_EXTRA, username).putExtra(Constant.LIMIT_EXTRA, limit));
    }
}
