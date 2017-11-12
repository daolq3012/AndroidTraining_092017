package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ListGitHubUserActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {

    private RecyclerView mRvListUserGitHub;
    private ListGitHubUserRecyclerViewAdapter mListGitHubUserRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_git_hub_user);
        mRvListUserGitHub = (RecyclerView) findViewById(R.id.listGitHubUserRecyclerView);

        mListGitHubUserRecyclerViewAdapter = new ListGitHubUserRecyclerViewAdapter(receiveData());
        mListGitHubUserRecyclerViewAdapter.setOnRecyclerViewItemClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRvListUserGitHub.setLayoutManager(layoutManager);
        mRvListUserGitHub.setAdapter(mListGitHubUserRecyclerViewAdapter);
    }

    private ArrayList<Item> receiveData() {
        return getIntent().getParcelableArrayListExtra(Constant.EXTRA_USER_LIST);
    }

    @Override
    public void OnItemClick(Item item) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(Constant.EXTRA_USER_DETAIL, item);
        startActivity(intent);
    }
}
