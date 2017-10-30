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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEdtRegisterUsername;
    private EditText mEdtRegisterEmail;
    private EditText mEdtRegisterPassword;
    private EditText mEdtRegisterConfirmPassword;
    private Button mBtnRegister;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addControl();
        addEvent();
    }

    private void addControl() {
        mEdtRegisterUsername = (EditText) findViewById(R.id.edtRegisterUsername);
        mEdtRegisterEmail = (EditText) findViewById(R.id.edtRegisterEmail);
        mEdtRegisterPassword = (EditText) findViewById(R.id.edtRegisterPassword);
        mEdtRegisterPassword.setTypeface(Typeface.DEFAULT);
        mEdtRegisterConfirmPassword = (EditText) findViewById(R.id.edtRegisterConfirmPassword);
        mEdtRegisterConfirmPassword.setTypeface(Typeface.DEFAULT);
        mBtnRegister = (Button) findViewById(R.id.btnRegister);

        builder = new AlertDialog.Builder(RegisterActivity.this,R.style.MyDialogTheme);
    }

    private void addEvent() {
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                String email = mEdtRegisterEmail.getText().toString();
                if(!Validate.isEmailValid(email)) {
                    builder.setTitle(R.string.email_error_title);
                    builder.setMessage(R.string.email_error_message);
                    builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mEdtRegisterEmail.setText("");
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                if (Validate.isPasswordWeak(mEdtRegisterPassword)) {
                    builder.setTitle(R.string.password_error_title);
                    builder.setMessage(R.string.password_error_message);
                    builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                break;
        }
    }
}
