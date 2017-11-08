package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // gan du lieu vao Recyclerview
    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<datashop> arrayList = new ArrayList<>();
        arrayList.add(new datashop(R.drawable.dh2));
        arrayList.add(new datashop(R.drawable.dh3));
        arrayList.add(new datashop(R.drawable.dh4));
        arrayList.add(new datashop(R.drawable.dh5));
        arrayList.add(new datashop(R.drawable.dh6));




    }
}
