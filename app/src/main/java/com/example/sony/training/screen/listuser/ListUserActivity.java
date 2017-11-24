package com.example.sony.training.screen.listuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sony.training.Constant;
import com.example.sony.training.MainApplication;
import com.example.sony.training.R;
import com.example.sony.training.data.config.GithubApi;
import com.example.sony.training.data.response.SearchGitHubUsersResponse;
import com.example.sony.training.model.User;
import com.example.sony.training.screen.detailuser.DetailUserActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity implements OnRecyclerViewItemClick, ListUserContract.View {

    private RecyclerView mRecyclerView;
    private ListUserAdapter mListUserAdapter;
    private ListUserContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        mRecyclerView = findViewById(R.id.listRecyclerView);

        mPresenter = new ListUserPresenter();
        mPresenter.setView(this);
        GithubApi githubApi = MainApplication.getmGithubApi();
        mPresenter.setGithubApi(githubApi);
        mListUserAdapter = new ListUserAdapter(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mListUserAdapter.setOnRecyclerViewItemClick(ListUserActivity.this);
        mRecyclerView.setAdapter(mListUserAdapter);
        mPresenter.getListUser();
    }

    @Override
    public void onItemClick(String name) {
        Intent intent = new Intent(this, DetailUserActivity.class).putExtra(Constant.EXTRA_USER, name);
        startActivity(intent);
    }

    @Override
    public void setData(List<User> users) {
        mListUserAdapter.updateData(users);
    }

    @Override
    public String getKeyword() {
        return getIntent().getStringExtra(Constant.EXTRA_USER);
    }

    @Override
    public int getLinmit() {
        return getIntent().getIntExtra(Constant.LIMIT_EXTRA, 0);
    }

}
