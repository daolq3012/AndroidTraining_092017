package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sony.training.Adapter.GithubUserAdapter;
import com.example.sony.training.model.User;
import com.example.sony.training.services.config.GitHubApi;
import com.example.sony.training.services.response.SearchGitHubUsersResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity implements OnRecyclerViewItemListener {

    private RecyclerView mRecyclerView;
    private GithubUserAdapter mGithubUserAdapter;
    private List<User> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        mRecyclerView = findViewById(R.id.listRecyclerView);

        getData();
    }

    private void getData(){
        mUsers = new ArrayList<>();
        String username = getIntent().getStringExtra(Constant.EXTRA_USER);
        int limit = getIntent().getIntExtra(Constant.LIMIT_EXTRA, 0);
        GitHubApi api = MainApplication.getmGithubApi();
        api.searchUserGitHub(limit, username).enqueue(new Callback<SearchGitHubUsersResponse>() {
            @Override
            public void onResponse(Call<SearchGitHubUsersResponse> call, Response<SearchGitHubUsersResponse> response) {
                mUsers = response.body().getItems();
                mGithubUserAdapter = new GithubUserAdapter(mUsers);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(mGithubUserAdapter);

                mGithubUserAdapter.setOnRecyclerViewItemListener(ListUserActivity.this);
            }

            @Override
            public void onFailure(Call<SearchGitHubUsersResponse> call, Throwable t) {

            }
        });
    }


    @Override
    public void onItemClick(String name) {
        Intent intent = new Intent(this, UserDeltailsActivity.class);
        intent.putExtra(Constant.EXTRA_USER, name);
        startActivity(intent);
    }
}
