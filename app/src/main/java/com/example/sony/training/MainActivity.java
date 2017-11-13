package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sony.training.Service.PlayMusicService;

public class MainActivity extends AppCompatActivity {

    private Button startServiceButton, stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = (Button) findViewById(R.id.startServiceButton);
        stopServiceButton = (Button) findViewById(R.id.stopServiceButton);

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayMusicService.class);
                startService(intent);
            }
        });

        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayMusicService.class);
                stopService(intent);
            }
        });
    }
}