package com.example.sony.training.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.sony.training.OnRecyclerViewItemClickListener;
import com.example.sony.training.R;
import com.example.sony.training.adapter.GitHubUserAdapter;
import com.example.sony.training.model.Item;

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

    }

    @Override
    public void onItemClick(Item user) {
        // create an intent
//        Intent intent = new Intent(this, UserDetailActivity.class);
//        intent.putExtra(Constant.EXTRA_USER,user);
//        this.startActivity(intent);
    }
}
