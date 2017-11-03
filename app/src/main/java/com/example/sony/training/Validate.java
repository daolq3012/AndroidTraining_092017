package com.example.sony.training;

import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 10/30/17.
 */

public class Validate {

    public static boolean isPasswordWeak(EditText editText) {
        if (editText.getText().toString().trim().length() < 6) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "[a-zA-Z0-9._-]+@[a-z]+(\\.+[a-z]+)+";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
