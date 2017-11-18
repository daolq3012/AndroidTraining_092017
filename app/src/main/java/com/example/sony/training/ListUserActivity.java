package com.example.sony.training;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.example.sony.training.adapter.ListUserRecyclerViewAdapter;
import com.example.sony.training.model.User;
import com.example.sony.training.service.config.GithubApi;
import com.example.sony.training.service.response.SearchGithubUserResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity implements OnItemRecyclerViewClick {

    private List<User> mUsers;
    private ListUserRecyclerViewAdapter mListUserRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private static final String TAG = "ListUserActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user2);

        mRecyclerView = findViewById(R.id.listUserRecyclerView);
        getData();
    }

    private void getData(){
        mUsers = new ArrayList<>();
        String username = getIntent().getStringExtra(Constant.USERNAME_EXTRA);
        int limit = getIntent().getIntExtra(Constant.LIMIT_EXTRA, 0);
        GithubApi api = MainApplication.getGithubApi();
        api.seacrhGithubUser(limit, username).enqueue(new Callback<SearchGithubUserResponse>() {
            @Override
            public void onResponse(Call<SearchGithubUserResponse> call,
                    Response<SearchGithubUserResponse> response) {
                mUsers = response.body().getItems();
                mListUserRecyclerViewAdapter = new ListUserRecyclerViewAdapter(mUsers);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(mListUserRecyclerViewAdapter);
                mListUserRecyclerViewAdapter.setOnItemRecyclerViewClick(ListUserActivity.this);
            }

            @Override
            public void onFailure(Call<SearchGithubUserResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }

    @Override
    public void OnItemClick(String username) {
        startActivity(new Intent(this, DetailActivity.class).putExtra(
                Constant.DETAIL_EXTRA, username));
    }
}
