package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sony.training.adapter.ContactAdapter;
import com.example.sony.training.model.Data;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewContact;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        mRecyclerViewContact.setHasFixedSize(true);
        mRecyclerViewContact.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerViewContact.setLayoutManager(layoutManager);
        contactAdapter = new ContactAdapter(Data.getListContacts(),getApplicationContext());
        mRecyclerViewContact.setAdapter(contactAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerViewContact.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerViewContact.addItemDecoration(dividerItemDecoration);
    }

    private void initViews() {
        mRecyclerViewContact = (RecyclerView) findViewById(R.id.recyclerViewContact);
    }
}
