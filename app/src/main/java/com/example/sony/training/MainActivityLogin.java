package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by phong on 10/31/17.
 */

public class MainActivityLogin extends AppCompatActivity implements View.OnClickListener{
    private EditText mEmail;
    private EditText mPassword;
    private Button btnLogin;
    private TextView mTxtPassword;
    private TextView mTxtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_login);
        initViews();
        setEventClickViews();
    }

    private void initViews() {
        mEmail = (EditText) findViewById(R.id.edtEmailLogin);
        mPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        mTxtPassword = (TextView) findViewById(R.id.btnPassword);
        mTxtRegister = (TextView) findViewById(R.id.btnRegister);

    }

    private void setEventClickViews() {
        mEmail.setOnClickListener(MainActivityLogin.this);
        mPassword.setOnClickListener(MainActivityLogin.this);
        btnLogin.setOnClickListener(MainActivityLogin.this);
        mTxtPassword.setOnClickListener(MainActivityLogin.this);
        mTxtRegister.setOnClickListener(MainActivityLogin.this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mEmail:
                mEmail.getText();
                break;
            case R.id.mPassword:
                mEmail.getText();
                break;
            case R.id.btnLogin:
                Toast.makeText(MainActivityLogin.this, "xin chào!", Toast.LENGTH_SHORT).show();
                break;
    }
}
