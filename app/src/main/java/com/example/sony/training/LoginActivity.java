package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;
    private TextView mRegister;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initEvents();
    }

    private void initEvents() {
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
    }

    private void initViews() {
        mEmail = (EditText) findViewById(R.id.tv_lg_email);
        mPassword = (EditText) findViewById(R.id.tv_lg_pass);
        mLogin = (Button) findViewById(R.id.btn_login);
        mRegister = (TextView) findViewById(R.id.tv_register);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                buttonClicked();
                break;
            case R.id.tv_register:
                textviewClicked();

        }
    }

    private void textviewClicked() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void buttonClicked() {
        String mail = mEmail.getText().toString();
        String pass = mPassword.getText().toString();
        if (mail.equals("thanhthang@gmail.com")
                && pass.equals("thanhthang")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu !", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
