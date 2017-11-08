package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new FetchDataFromUrl().execute("https://api.github.com/search/users?per_page=2&q=abc");
    }
}
