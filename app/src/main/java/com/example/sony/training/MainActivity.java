package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.sony.training.service.config.GithubApi;
import com.example.sony.training.service.config.ServiceGenerators;
import com.example.sony.training.service.response.SearchGithubUserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button mBtnSearch;
    private EditText mEdtUserName, mEdtLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSearch = findViewById(R.id.searchButton);
        mEdtUserName = findViewById(R.id.userNameEdittext);
        mEdtLimit = findViewById(R.id.limitEdittext);

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEdtUserName.getText().toString();
                int limit = Integer.parseInt(mEdtLimit.getText().toString());
                startActivity(new Intent(MainActivity.this, ListUserActivity.class).putExtra(
                        Constant.USERNAME_EXTRA, username).putExtra(Constant.LIMIT_EXTRA, limit));
            }
        });


    }
}
