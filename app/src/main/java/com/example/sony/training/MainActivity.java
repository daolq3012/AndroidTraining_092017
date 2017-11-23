package com.example.sony.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mKeyword, mLimit;
    private Button btnSearch;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        onClickViews();

        progressDialog = new ProgressDialog(this);
    }

    private void onClickViews() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mKeyword.getText().toString();
                String mLimitUser = mLimit.getText().toString();
                int limit = Integer.parseInt(mLimitUser);

                    progressDialog.show();

                    startActivity(new Intent(MainActivity.this, ListUsersActivity.class).putExtra(
                            Constant.EXTRA_USER_LIST, name).putExtra(Constant.EXTRA_USER_LIMIT, limit));


            }
        });
    }

    private void initViews() {
        mKeyword = findViewById(R.id.edtKeyword);
        mKeyword.setError("Enter your keyword");
        mLimit = findViewById(R.id.edtLimit);
        mLimit.setError("Enter your limit number");
        btnSearch = findViewById(R.id.btnSearch);
        progressDialog = new ProgressDialog(this);
    }
}
