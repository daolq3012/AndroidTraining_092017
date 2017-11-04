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
    private FieldCheckValidate fieldCheckValidate = new FieldCheckValidate();
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



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_Button:
                if (fieldCheckValidate.checkLogin(mEdtEmail,mEdtPassword,this)){
                    startActivity(new Intent(this, MainActivity.class));
                }
                break;
            case R.id.register_TextView:
                startActivity(new Intent(this,RegisterForm.class));
                break;
        }
    }
}