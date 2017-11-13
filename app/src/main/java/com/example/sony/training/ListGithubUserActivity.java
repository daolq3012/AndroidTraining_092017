package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.example.sony.training.adapter.GithubUserAdapter;
import java.util.ArrayList;

public class ListGithubUserActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {

    private RecyclerView mRecyclerViewGithubUsers;
    private GithubUserAdapter mGithubUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_github_user);

        ArrayList<Item> items = getIntent().getParcelableArrayListExtra(Constrants.EXTRA_USER_LIST);

        mRecyclerViewGithubUsers = (RecyclerView) findViewById(R.id.recyclerViewGithubUsers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewGithubUsers.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerViewGithubUsers.getContext(),
                        DividerItemDecoration.VERTICAL);
        mGithubUserAdapter = new GithubUserAdapter(items);
        mGithubUserAdapter.setOnRecyclerViewItemClickListener(this);
        mRecyclerViewGithubUsers.addItemDecoration(dividerItemDecoration);
        mRecyclerViewGithubUsers.setAdapter(mGithubUserAdapter);
    }

    @Override
    public void OnItemClick(Item item) {
        Intent intent = new Intent(this,UserDetailActivity.class);
        intent.putExtra(Constrants.EXTRA_USER,item);
        this.startActivity(intent);
    }
}
