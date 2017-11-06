package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerViewAdapter viewAdapter = new RecyclerViewAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter viewAdapter1 = new RecyclerViewAdapter(this);
        mRecyclerView.setAdapter(viewAdapter);

        List<User> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(new User("phongchau",21));
        }

        viewAdapter.updateData(strings);
    }
}
