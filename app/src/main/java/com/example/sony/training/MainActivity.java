package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private List<User> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter viewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(viewAdapter);

        strings.add(new User("Vũ Nguyễn 1",28));
        strings.add(new User("Vũ Nguyễn 2",27));
        strings.add(new User("Vũ Nguyễn 3",26));
        strings.add(new User("Vũ Nguyễn 4",25));
        strings.add(new User("Vũ Nguyễn 5",24));
        strings.add(new User("Vũ Nguyễn 6",23));
        strings.add(new User("Vũ Nguyễn 7",22));
        strings.add(new User("Vũ Nguyễn 8",21));
        strings.add(new User("Vũ Nguyễn 9",20));

        viewAdapter.updateData(strings);
    }
}