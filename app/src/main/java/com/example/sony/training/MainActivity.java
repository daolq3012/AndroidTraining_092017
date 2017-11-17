package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button insertButton, listUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();

    }

    private void initViews() {

        insertButton = findViewById(R.id.insertButton);
        listUserButton = findViewById(R.id.listUserButton);

    }

    private void initEvents() {

        insertButton.setOnClickListener(this);
        listUserButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.insertButton:
                Intent intent = new Intent(this, InsertUserActivity.class);
                startActivity(intent);
                break;
            case R.id.listUserButton:
                Intent intent1 = new Intent(this, ListUserActivity.class);
                startActivity(intent1);
                break;
        }

    }
}