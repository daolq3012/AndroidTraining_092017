package com.example.sony.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements OnFetchDataListener {
    private EditText mKeyword, mLimitNumber;
    private Button btnSearch;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        init();
        btnClickListener();

        progressDialog = new ProgressDialog(this);
    }

    private void btnClickListener() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = mKeyword.getText().toString();
                String limit = mLimitNumber.getText().toString();
                if (keyword.isEmpty() || limit.isEmpty()) {
                    return;
                }
                progressDialog.show();
                new FetchDataFromUrl(SearchActivity.this).execute("https://api.github.com/search/users?per_page="
                        + limit + "&q=" + keyword);
            }
        });
    }

    private void init() {
        mKeyword = (EditText) findViewById(R.id.edtKeyword);
        mLimitNumber = (EditText) findViewById(R.id.limitNumberEdittext);
        btnSearch = (Button) findViewById(R.id.btnSearch);
    }

    @Override
    public void onFetchDataSuccess(List<Item> users) {
        ArrayList<Item> items = (ArrayList<Item>) users;
        progressDialog.dismiss();
        Intent intent = new Intent(this, ListGitHubUserActivity.class);
        intent.putParcelableArrayListExtra(Constant.EXTRA_USER_LIST, items);
        startActivity(intent);

    }
}
