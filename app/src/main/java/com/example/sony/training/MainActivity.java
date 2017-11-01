package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();
        getFragmentManager().beginTransaction().add(R.id.container_first_fragment,firstFragment).commitAllowingStateLoss();
    }
}
