package com.example.sony.training.screen.listuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.R;
import com.example.sony.training.constant.Constant;
import com.example.sony.training.screen.detailuser.DetailActivity;
import com.example.sony.training.screen.listuser.adapter.ListUserRecyclerViewAdapter;
import com.example.sony.training.model.User;
import com.example.sony.training.data.service.config.GithubApi;
import com.example.sony.training.data.service.response.SearchGithubUserResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity
        implements OnItemRecyclerViewClick, ListUserContract.View {

    private List<User> mUsers;
    private ListUserRecyclerViewAdapter mListUserRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private static final String TAG = "ListUserActivity";
    private ListUserPresenter mPresenter;
    private GithubApi mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user2);

        mRecyclerView = findViewById(R.id.listUserRecyclerView);

        mApi = MainApplication.getGithubApi();

        mPresenter = new ListUserPresenter();
        mPresenter.setView(this);
        mPresenter.setApi(mApi);
        mPresenter.getDataFromInternet();

        mListUserRecyclerViewAdapter = new ListUserRecyclerViewAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mListUserRecyclerViewAdapter);

        mListUserRecyclerViewAdapter.setOnItemRecyclerViewClick(ListUserActivity.this);
    }

    @Override
    public void OnItemClick(String username) {
        startActivity(
                new Intent(this, DetailActivity.class).putExtra(Constant.DETAIL_EXTRA, username));
    }

    @Override
    public String getUsername() {
        return getIntent().getStringExtra(Constant.USERNAME_EXTRA);
    }

    @Override
    public int getLimit() {
        return getIntent().getIntExtra(Constant.LIMIT_EXTRA, 0);
    }

    @Override
    public void receiveData(List<User> users) {
       mListUserRecyclerViewAdapter.updateData(users);
    }

    @Override
    public void showToastFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
