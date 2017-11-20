package com.example.sony.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUsersActivity extends Activity implements OnRecyclerViewItemClickListener  {

    private List<User> mUsers;
    private ListUserRecyclerViewAdapter mListUserRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private static final String TAG = "ListUsersActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        mRecyclerView = findViewById(R.id.recycler_views);
        getData();
    }

    private void getData() {
        mUsers = new ArrayList<>();
        String keyword = getIntent().getStringExtra(Constant.EXTRA_USER_LIST);
        int limit = getIntent().getIntExtra(Constant.EXTRA_USER_LIMIT, 0);
        GitHubApi api = MainApplication.getGithubApi();
        api.seacrhGithubUser(limit, keyword).enqueue(new Callback<SearchGitHubUsersResponse>() {
            @Override
            public void onResponse(Call<SearchGitHubUsersResponse> call,
                                   Response<SearchGitHubUsersResponse> response) {
                mUsers = response.body().getItems();
                mListUserRecyclerViewAdapter = new ListUserRecyclerViewAdapter(mUsers);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(mListUserRecyclerViewAdapter);
                mListUserRecyclerViewAdapter.setOnItemRecyclerViewClick(ListUsersActivity.this);
            }

            @Override
            public void onFailure(Call<SearchGitHubUsersResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }

    @Override
    public void onUserClick(String user) {
        startActivity(new Intent(this, DetailUsersActivity.class).putExtra(
                Constant.EXTRA_DETAIL_USER, user));
    }
}
