package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginForm extends AppCompatActivity implements View.OnClickListener {
    private EditText mEdtEmail, mEdtPassword;
    private Button mBtnLogin;
    private TextView mTxtRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        initViews();

        initListeners();
    }

    private void initViews(){
        mEdtEmail = (EditText) findViewById(R.id.email_EditText);
        mEdtPassword = (EditText) findViewById(R.id.password_EditText);
        mBtnLogin = (Button) findViewById(R.id.login_Button);
        mTxtRegister = (TextView) findViewById(R.id.register_TextView);
    }

    private void initListeners(){
        mBtnLogin.setOnClickListener(this);
        mTxtRegister.setOnClickListener(this);
    }

    private void checkLogin(){
        String email = mEdtEmail.getText().toString();
        String password = mEdtPassword.getText().toString();
        if (email.length() > 6 || password.length() > 6){
            Toast.makeText(this, R.string.loginSuccess, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.validateEmail_Password, Toast.LENGTH_SHORT).show();
            mEdtEmail.setText("");
            mEdtPassword.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_Button:
                checkLogin();
                break;
            case R.id.register_TextView:
                startActivity(new Intent(this,RegisterForm.class));
                break;
        }
    }
}
