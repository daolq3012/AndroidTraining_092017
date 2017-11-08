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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnFetchDataListener{
    private EditText mKeyWord, mSoLuong;
    private Button mSearch;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKeyWord = (EditText) findViewById(R.id.edtKeyword);
        mSoLuong = (EditText) findViewById(R.id.editSoluong);
        mSearch = (Button) findViewById(R.id.btnSearch);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        mSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSearch:
                String keyword = mKeyWord.getText().toString();
                String soluong = mSoLuong.getText().toString();
                if (keyword.isEmpty() || soluong.isEmpty()){
                    return;
                }
                dialog.show();
                new FetchDataFromUrl(MainActivity.this).execute("https://api.github.com/search/users?per_page=" + soluong + "&q=" + keyword);
                break;
        }
    }

    @Override
    public void onFetchDataSuccess(List<Item> items) {
        ArrayList<Item> items1 = (ArrayList<Item>) items;
        dialog.dismiss();
        Intent intent = new Intent(this, ListGitHubUserActivity.class);
        intent.putParcelableArrayListExtra(Constant.EXTRA_USER_LIST, items1);
        startActivity(intent);
    }
}