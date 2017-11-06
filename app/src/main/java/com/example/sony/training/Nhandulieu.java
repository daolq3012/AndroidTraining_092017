package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.name;
import static android.R.attr.password;

public class Nhandulieu extends AppCompatActivity {
    private TextView nhandl,nhanpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhandulieu);
        nhansilieu();
    }
    public  void nhansilieu(){

        nhandl = (TextView) findViewById(R.id.usernamedl);
        nhanpass = (TextView) findViewById(R.id.nhanpass);

        Intent intent = getIntent();
        Bundle bundle =  intent.getExtras();

          String Name =  bundle.getString("name");

        String pass = bundle.getString("pas");
        nhandl.setText(pass);
        nhanpass.setText(Name);




    }
}
