package com.example.sony.training.screen.searchuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sony.training.Constant;
import com.example.sony.training.R;
import com.example.sony.training.screen.listuser.ListUserActivity;

public class SearchUserActivity extends AppCompatActivity implements SearchUserContract.View {

    private SearchUserContract.Presenter mPresenter;
    private EditText keywordEditText, limitEditText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        initView();
        initEvent();

        mPresenter = new SearchUserPresenter();
        mPresenter.setView(this);

    }

    private void initView() {
        keywordEditText = findViewById(R.id.keywordEditText);
        limitEditText = findViewById(R.id.limitEditText);
        searchButton = findViewById(R.id.searchButton);
    }

    private void initEvent() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.search();
            }
        });
    }

    @Override
    public String getKeyword() {
        return keywordEditText.getText().toString().trim();
    }

    @Override
    public int getLimit() {
        return Integer.parseInt(limitEditText.getText().toString().trim());
    }

    @Override
    public void showToastSearchFail(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidateKeyWordLimitSuccess(String keyword, int limit) {
        Intent intent = new Intent(this, ListUserActivity.class).putExtra(Constant.EXTRA_USER, keyword).putExtra(Constant.LIMIT_EXTRA, limit);
        startActivity(intent);
    }
}
