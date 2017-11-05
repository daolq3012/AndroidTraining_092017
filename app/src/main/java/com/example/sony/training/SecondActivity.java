package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTxtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();

        String data = getIntent().getStringExtra(Constant.KEY_DATA_INPUT);
        mTxtData.setText(data);
    }

    private void initViews() {
        mTxtData = (TextView) findViewById(R.id.txtData);
    }
}
