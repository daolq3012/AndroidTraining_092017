package com.example.sony.training.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.sony.training.Constant;
import com.example.sony.training.OnFetchDataListener;
import com.example.sony.training.OnRecyclerViewItemClickListener;
import com.example.sony.training.R;
import com.example.sony.training.adapter.GitHubUserAdapter;
import com.example.sony.training.handler.FetchDataFromUrl;
import com.example.sony.training.model.User;
import java.util.List;

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

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        new FetchDataFromUrl(new OnFetchDataListener() {
            @Override
            public void onFetchDataSuccess(List<User> users) {
                mGitHubUserAdapter.updateData(users);
                dialog.dismiss();
            }
        }).execute("https://api.github.com/search/users?per_page=2&q=daolq");
    }

    @Override
    public void onItemClick(User user) {
        // create an intent
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(Constant.EXTRA_USER,user);
        this.startActivity(intent);
    }
}
