package com.example.sony.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by phong on 11/08/17.
 */

public class ListGitHubUserActivity extends Activity implements OnRecyclerViewItemClickListener {
    private RecyclerView mRecyclerViewNewsFeed;
    private GitHubUserAdapter mGitHubUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_users);

        mRecyclerViewNewsFeed = (RecyclerView) findViewById(R.id.recyclerItems);

        mGitHubUserAdapter = new GitHubUserAdapter(this);
        mGitHubUserAdapter.setOnRecyclerViewItemClickListener(this);
        mRecyclerViewNewsFeed.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewNewsFeed.setAdapter(mGitHubUserAdapter);

        ArrayList<Item> items = getIntent().getParcelableArrayListExtra(Constant.EXTRA_USER_LIST);
        mGitHubUserAdapter.updateData(items);
    }

    @Override
    public void onItemClick(Item item) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(Constant.EXTRA_USER, item);
        this.startActivity(intent);
    }
}
