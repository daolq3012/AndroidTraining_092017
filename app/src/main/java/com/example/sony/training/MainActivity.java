package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private List<Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewAdapter = new RecyclerViewAdapter(createData());

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private List<Item> createData(){
        data = new ArrayList<>();
        data.add(new Item("Chuong",20));
        data.add(new Item("Truyen",20));
        data.add(new Item("Nguyen",21));
        data.add(new Item("Nhac",20));
        data.add(new Item("Trung",20));
        data.add(new Item("Phuc",20));
        return data;
    }
}
