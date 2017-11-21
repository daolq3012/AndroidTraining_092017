package com.example.sony.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button insertMemberButton;
    private Button viewListMemberButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        insertMemberButton = findViewById(R.id.btn_input_member);
        viewListMemberButton = findViewById(R.id.btn_show_list_member);

        insertMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateMemberActivity.class));
            }
        });
        viewListMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListMemberActivity.class));
            }
        });

    }
}
