package com.example.sony.training.screen.main;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainContract.View {

    private static final String TAG = "MainActivity";
    private EditText mEdtKeyword, mEdtLimit;
    private Button mBtnSearch;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();

        mPresenter = new MainPresenter();
        mPresenter.setView(this);
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
                String keyword = mEdtKeyword.getText().toString();
                String limit = mEdtLimit.getText().toString();
                mPresenter.getInput();
                break;
        }
    }

    @Override
    public String getKeyword() {
        return mEdtKeyword.getText().toString().trim();
    }

    @Override
    public String getLimit() {
        return mEdtLimit.getText().toString().trim();
    }

    @Override
    public void showEmptyMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void openListUserActivity(String keyword, String limit) {
        Intent intent = new Intent(this,ListUserActivity.class);
        intent.putExtra(Constant.EXTRA_KEYWORD,keyword);
        intent.putExtra(Constant.EXTRA_LIMIT,limit);
        startActivity(intent);
    }
}
