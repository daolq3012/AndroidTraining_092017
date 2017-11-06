package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private Button bt1, bnt2 , bt3, bt4 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public  void  isven(){
        // bt1 = (Button) findViewById(R.id.button);
        // bnt2 = (Button) findViewById(R.id.button2);
        // bt3 = (Button) findViewById(R.id.button3);
        // bt4 = (Button) findViewById(R.id.button5);
        bt1.setOnClickListener(this);
        bnt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }

    }
    public void chuyenmanhinh(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
