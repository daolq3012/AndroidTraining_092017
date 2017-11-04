package com.example.sony.training;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 10/30/17.
 */

public class FieldCheckValidate {
    public boolean checkLogin(EditText mEdtEmail, EditText mEdtPassword, Context context) {
        String email = mEdtEmail.getText().toString();
        String password = mEdtPassword.getText().toString();
        if (email.length() > 6 || password.length() > 6) {
            Toast.makeText(context, R.string.loginSuccess, Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(context, R.string.validateEmail_Password, Toast.LENGTH_SHORT).show();
            mEdtEmail.setText("");
            mEdtPassword.setText("");
            return false;
        }
    }
}