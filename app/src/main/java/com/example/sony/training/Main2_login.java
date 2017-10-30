package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2_login extends AppCompatActivity implements View.OnClickListener {

    private EditText username, password;
    private TextView login  , regisrt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_login);
        username = (EditText) findViewById(R.id.usename);
        password = (EditText) findViewById(R.id.pass);
        login = (TextView) findViewById(R.id.login);
        regisrt = (TextView) findViewById(R.id.registerTextView);



        login.setOnClickListener(this);
        regisrt.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        String name = username.getText().toString();
        String  pass= password.getText().toString();

        switch(view.getId()){
            case R.id.login :
                if (name.equals("") || pass.equals("")){
                    Toast.makeText(this,"ten va mat khau khong duoc de trong ",Toast.LENGTH_LONG).show();

                }
                if (name.equals("hoaibaohue@gmail.com") && pass.equals("hoaibaohue ") ){
                    Toast.makeText(this,"dang nhap thanh cong ",Toast.LENGTH_LONG ).show();

                }
                break;
            case R.id.registerTextView:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}
