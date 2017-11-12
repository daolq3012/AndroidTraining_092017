package com.example.sony.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class SearchUserGitHubActivity extends AppCompatActivity
        implements View.OnClickListener, OnFetchDataListener {
    private TextView mTxtKeyWord, mTxtNumberDisplay;
    private EditText mEdtKeyWord, mEdtNumberDisplay;
    private Button mBtnSearch;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user_git_hub);
        initViews();

        //tao dialog de biet khi dang load du lieu
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");

        initListeners();
    }

    private void initListeners() {
        mBtnSearch.setOnClickListener(this);
    }

    private void initViews() {
        mTxtKeyWord = (TextView) findViewById(R.id.keyWordTextView);
        mTxtNumberDisplay = (TextView) findViewById(R.id.numberDisplayTextView);
        mEdtKeyWord = (EditText) findViewById(R.id.keyWordEdittext);
        mEdtNumberDisplay = (EditText) findViewById(R.id.numberDisplayEdittext);
        mBtnSearch = (Button) findViewById(R.id.searchButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchButton:
                String keyword = mEdtKeyWord.getText().toString();
                String numberdisplay = mEdtNumberDisplay.getText().toString();
                if (keyword.isEmpty() || numberdisplay.isEmpty()) {
                    return;
                }
                progressDialog.show();
                new FetchDataFromUrl(this).execute("https://api.github.com/search/users?per_page="
                        + numberdisplay
                        + "&q="
                        + keyword);
                break;
        }
    }

    @Override
    public void onFetchDataSuccess(List<Item> users) {
        ArrayList<Item> items = (ArrayList<Item>) users;
        // du lieu load xong thi tat dialog.
        progressDialog.dismiss();
        Intent intent = new Intent(this, ListGitHubUserActivity.class);
        intent.putParcelableArrayListExtra(Constant.EXTRA_USER_LIST, items);
        startActivity(intent);
    }
}
