package com.example.sony.training;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_EMAIL_TO_MAIN = "KEY_EMAIL_TO_MAIN";
    public static final String KEY_PASSWORD_TO_MAIN = "KEY_PASSWORD_TO_MAIN";
    public static final String KEY_EMAIL_FROM_REGISTER = "KEY_EMAIL_FROM_REGISTER";
    public static final int REQUEST_CODE_REGISTER = 1;

    private Context context;
    private EditText edtEmail;
    private EditText edtPass;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        connectView();
    }

    private void connectView() {
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtPass = (EditText) findViewById(R.id.edt_password);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.txt_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_login:
                login();
                break;
            case R.id.txt_register:
                register();
                break;
        }
    }

    private void login() {
        boolean error = false;

        showProgress(true);
        // when process we must have sometime

        // get data
        String email = edtEmail.getText().toString().trim();
        String password = edtPass.getText().toString().trim();

        // password empty
        if (TextUtils.isEmpty(password)) {
            edtPass.requestFocus();
            edtPass.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // email empty
        if (TextUtils.isEmpty(email)) {
            edtEmail.requestFocus();
            edtEmail.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // all data is ok
        showProgress(false);

        if (!error) {
            // create intent to show Main Activity
            Intent intent = new Intent(context, MainActivity.class);

            // send data if need
            intent.putExtra(KEY_EMAIL_TO_MAIN, email);
            intent.putExtra(KEY_PASSWORD_TO_MAIN, password);

            // start Main Activity
            startActivity(intent);
        }
    }

    private void register() {
        Intent intent = new Intent(context, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_CODE_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_REGISTER && resultCode == Activity.RESULT_OK) {
            String email = data.getStringExtra(KEY_EMAIL_FROM_REGISTER);
            edtEmail.setText(email);
            edtPass.requestFocus();
        }
    }

    private void showProgress(boolean isShow) {
        progressBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
        findViewById(R.id.login_form).setVisibility(!isShow ? View.VISIBLE : View.GONE);
    }
}
