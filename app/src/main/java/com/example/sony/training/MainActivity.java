package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sony.training.data.ApiService;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        handleEvents();

        mPresenter = new MainPresenter();
        mPresenter.setView(this);
        ApiService apiService = new ApiService();
        mPresenter.setApiService(apiService);
    }

    private void initViews() {
        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
    }

    private void handleEvents() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });
    }

    @Override
    public String getUsername() {
        return mEdtUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mEdtPassword.getText().toString().trim();
    }

    @Override
    public void showToastLoginSuccess() {
        Toast.makeText(this,"Login Success!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToastLoginFail(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
