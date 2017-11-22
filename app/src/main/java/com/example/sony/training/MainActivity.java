package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText keywordEditText, limitEditText;
    private Button searchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keywordEditText = findViewById(R.id.keywordEditText);
        limitEditText = findViewById(R.id.limitEditText);
        searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchButton:
                String keyword = keywordEditText.getText().toString();
                int limit = Integer.parseInt(limitEditText.getText().toString());

                Intent intent = new Intent(this, ListUserActivity.class).putExtra(Constant.EXTRA_USER, keyword).putExtra(Constant.LIMIT_EXTRA, limit);
                startActivity(intent);

                break;
        }
    }
}