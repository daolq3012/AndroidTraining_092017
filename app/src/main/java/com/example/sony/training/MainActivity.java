package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.sony.training.service.PlayMusicService;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStartService,mBtnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication application = new MainApplication();
        application.getConnectInternet();

        mBtnStartService = (Button) findViewById(R.id.btnStartService);
        mBtnStopService = (Button) findViewById(R.id.btnStopService);

        mBtnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayMusicService.class);
                startService(intent);
            }
        });
        mBtnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlayMusicService.class);
                stopService(intent);
            }
        });
    }
}
