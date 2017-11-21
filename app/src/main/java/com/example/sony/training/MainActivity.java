package com.example.sony.training;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.sony.training.model.User;
import com.example.sony.training.service.config.GitHubApi;
import com.example.sony.training.service.config.ServiceGenerators;
import com.example.sony.training.service.response.SearchGithubUserResponse;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private EditText mEdtKeyword, mEdtLimit;
    private Button mBtnSearch;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading...");
    }

    private void initViews() {
        mEdtKeyword = findViewById(R.id.edtKeyword);
        mEdtLimit = findViewById(R.id.edtLimit);
        mBtnSearch = findViewById(R.id.btnSearch);
    }

    private void initEvents() {
        mBtnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSearch:
                mProgressDialog.show();
                String keyword = mEdtKeyword.getText().toString();
                int limit = Integer.valueOf(mEdtLimit.getText().toString());
                MainApplication.getGitHubApi().searchUserGithub(limit,keyword).enqueue(new Callback<SearchGithubUserResponse>() { //enqueue nhu execute cua AsyncTask
                    @Override
                    public void onResponse(Call<SearchGithubUserResponse> call,
                            Response<SearchGithubUserResponse> response) {
                        ArrayList<User> listItems = (ArrayList<User>) response.body().getItems();
                        mProgressDialog.dismiss();
                        Intent intent = new Intent(MainActivity.this,ListUserActivity.class);
                        intent.putParcelableArrayListExtra(Constant.EXTRA_LIST_USER,listItems);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<SearchGithubUserResponse> call, Throwable t) { //Fail khi tat internet
                        Log.e(TAG, "onFailure: ",t);
                    }
                });
                break;
        }
    }
}
