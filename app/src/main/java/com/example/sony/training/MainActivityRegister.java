package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by phong on 11/01/17.
 */

public class MainActivityRegister extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNameRegister;
    private EditText edtEmailRegister;
    private EditText edtPhoneRegister;
    private EditText edtPasswordRegister;
    private Button btnAddphotoRegister;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        setEventClickViews();
    }

    private void initViews() {
        edtNameRegister = (EditText) findViewById(R.id.edtName);
        edtEmailRegister = (EditText) findViewById(R.id.edtEmail);
        edtPhoneRegister = (EditText) findViewById(R.id.edtPhone);
        edtPasswordRegister = (EditText) findViewById(R.id.edtPasswordSignup);
        btnAddphotoRegister = (Button) findViewById(R.id.btnAddPhoto);
        btnRegister = (Button) findViewById(R.id.btnRegisterSignup);
    }

    private void setEventClickViews() {
        edtNameRegister.setOnClickListener(MainActivityRegister.this);
        edtEmailRegister.setOnClickListener(MainActivityRegister.this);
        edtPhoneRegister.setOnClickListener(MainActivityRegister.this);
        edtPasswordRegister.setOnClickListener(MainActivityRegister.this);
        btnAddphotoRegister.setOnClickListener(MainActivityRegister.this);
        btnRegister.setOnClickListener(MainActivityRegister.this);
    }

    @Override
    public void onClick(View v) {

    }

}
