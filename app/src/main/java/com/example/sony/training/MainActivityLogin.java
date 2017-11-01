package com.example.sony.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by phong on 10/31/17.
 */

public class MainActivityLogin extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmailLogin;
    private EditText mPasswordLogin;
    private Button btnLogin;
    private Button btnPasswordLogin;
    private Button btnRegisterLogin;

    private static final String TAG = "MainActivityLogin";
    private static final int REQUEST_SIGNUP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_login);

    }

    @Override
    public void onClick(View v) {
        login();
    }

    private void initViews() {
        mEmailLogin = (EditText) findViewById(R.id.edtEmailLogin);
        mPasswordLogin = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnPasswordLogin = (Button) findViewById(R.id.btnPassword);
        btnRegisterLogin = (Button) findViewById(R.id.btnRegister);

    }

    private void setEventClickViews() {
        mEmailLogin.setOnClickListener(MainActivityLogin.this);
        mPasswordLogin.setOnClickListener(MainActivityLogin.this);
        btnLogin.setOnClickListener(MainActivityLogin.this);
        btnPasswordLogin.setOnClickListener(MainActivityLogin.this);
        btnRegisterLogin.setOnClickListener(MainActivityLogin.this);
    }

    private void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(MainActivityLogin.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = mEmailLogin.getText().toString();
        String password = mPasswordLogin.getText().toString();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivityLogin
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        btnLogin.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        btnLogin.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        String email = mEmailLogin.getText().toString();
        String password = mPasswordLogin.getText().toString();
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailLogin.setError("Enter a valid email address");
            valid = false;
        } else {
            mEmailLogin.setError(null);
        }
        if (password.isEmpty() || password.length() < 7 ) {
            mPasswordLogin.setError("Alphanumeric characters > 6");
            valid = false;
        } else {
            mPasswordLogin.setError(null);
        }
        return valid;
    }
}
