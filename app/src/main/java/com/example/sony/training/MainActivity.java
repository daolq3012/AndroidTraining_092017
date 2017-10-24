package com.example.sony.training;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtUserName;
    private TextView mTxtUserName;
    private Spinner mSpinner;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_test);

        mEdtUserName = (EditText) findViewById(R.id.edtUserName);
        mTxtUserName = (TextView) findViewById(R.id.txtUserName);
        mSpinner = (Spinner) findViewById(R.id.spinner_email);
        mTxtUserName.setTextColor(getColor(R.color.colorAccent));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_email, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);


    }
}
