package com.example.sony.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class SearchUserGithubActivity extends AppCompatActivity
        implements View.OnClickListener, OnFetchDataListener {

    private EditText mEdtKeyword;
    private EditText mEdtNumberResults;
    private Button mBtnSearch;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user_github);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading");
        initViews();
        initEvents();
    }

    private void initViews() {
        mEdtKeyword = (EditText) findViewById(R.id.edtKeyword);
        mEdtNumberResults = (EditText) findViewById(R.id.edtNumberResults);
        mBtnSearch = (Button) findViewById(R.id.btnSearch);
    }

    private void initEvents() {
        mBtnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                String keyword = mEdtKeyword.getText().toString();
                String numberResults = mEdtNumberResults.getText().toString();
                if (keyword.isEmpty() || numberResults.isEmpty()) {
                    return;
                }
                mProgressDialog.show();
                new FetchDataFromUrl(this).execute(
                        "https://api.github.com/search/users?per_page=" + numberResults + "&q="
                                + keyword);
        }
    }

    @Override
    public void onFetchDataSuccess(List<Item> users) {
        ArrayList<Item> items = (ArrayList<Item>) users;
        mProgressDialog.dismiss();
        Log.d("truyen","onFetchDataSuccess" + users);
        Intent intent = new Intent(this,ListGithubUserActivity.class);
        intent.putParcelableArrayListExtra(Constrants.EXTRA_USER_LIST,items);
        startActivity(intent);
    }
}
