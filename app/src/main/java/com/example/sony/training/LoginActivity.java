package com.example.sony.training;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEdtLoginUsername;
    private EditText mEdtLoginPassword;
    private Button mBtnLogin;
    private TextView mTxtLoginSignUp;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControl();
        addEvent();

    }

    private void addControl() {
        mEdtLoginUsername = (EditText) findViewById(R.id.edtLoginUsername);
        mEdtLoginPassword = (EditText) findViewById(R.id.edtLoginPassword);
        mEdtLoginPassword.setTypeface(Typeface.DEFAULT);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mTxtLoginSignUp = (TextView) findViewById(R.id.txtLoginSignUp);

        builder = new AlertDialog.Builder(LoginActivity.this,R.style.MyDialogTheme);
    }

    private void addEvent() {
        mBtnLogin.setOnClickListener(this);
        mTxtLoginSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if(Validate.isPasswordWeak(mEdtLoginPassword)) {
                    builder.setTitle("Weak");
                    builder.setMessage("Password must more than 6 character");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                break;
            case R.id.txtLoginSignUp:
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
        }
    }
}
