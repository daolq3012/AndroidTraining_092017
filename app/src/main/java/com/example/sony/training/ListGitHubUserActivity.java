package com.example.sony.training;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListGitHubUserActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {
    private RecyclerView mRecyclerViewNewsFeed;
    private GitHubUserAdapter mGitHubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_git_hub_user);

        mRecyclerViewNewsFeed = (RecyclerView) findViewById(R.id.recyclerItem);

        mGitHubAdapter = new GitHubUserAdapter(this);
        mGitHubAdapter.setOnRecyclerViewItemClickListener(this);
        mRecyclerViewNewsFeed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewNewsFeed.setAdapter(mGitHubAdapter);

        ArrayList<Item> items = getIntent().getParcelableArrayListExtra(Constant.EXTRA_USER_LIST);
        mGitHubAdapter.updateData(items);
    }

    @Override
    public void onItemClick(Item item) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(Constant.EXTRA_USER, item);
        this.startActivity(intent);
    }
}
