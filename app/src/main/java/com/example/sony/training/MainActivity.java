package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(Constant.TEST_ACTION);
        sendBroadcast(intent);
    }

    public void OnSendBroadCastIsClick(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}
