package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.FocusFinder;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     private EditText meditusename ;
    private  EditText PASSWORD ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
