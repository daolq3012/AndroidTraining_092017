package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextViewData = (TextView) findViewById(R.id.txtData);

        String data = getIntent().getStringExtra(Constant.KEY_DATA_INPUT);
        mTextViewData.setText(data);
    }
}
