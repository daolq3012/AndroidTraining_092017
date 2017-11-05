package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ThanhThang on 03/11/2017.
 */

public class SecondActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        mTextView = (TextView) findViewById(R.id.txtData);

        String data = getIntent().getStringExtra(Constant.KEY_DATA_INPUT);

        mTextView.setText(data);
    }
}
