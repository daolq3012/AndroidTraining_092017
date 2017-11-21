package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.example.sony.training.adapter.GithubUserAdapter;
import com.example.sony.training.model.User;
import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity implements OnRecyclerViewItemListener {

    private RecyclerView mRecyclerViewUser;
    private GithubUserAdapter mGithubUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        mRecyclerViewUser = findViewById(R.id.recyclerViewUser);

        ArrayList<User> listItems = getIntent().getParcelableArrayListExtra(Constant.EXTRA_LIST_USER);

        mGithubUserAdapter = new GithubUserAdapter(listItems, this);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                        false);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerViewUser.getContext(),
                        DividerItemDecoration.VERTICAL);
        mRecyclerViewUser.setLayoutManager(layoutManager);
        mRecyclerViewUser.addItemDecoration(dividerItemDecoration);
        mGithubUserAdapter.setOnRecyclerViewItemListener(this);
        mRecyclerViewUser.setAdapter(mGithubUserAdapter);
    }

    @Override
    public void onItemClick(User user) {
        Intent intent = new Intent(this,UserDetailsActivity.class);
        intent.putExtra(Constant.EXTRA_USERNAME,user.getLogin());
        startActivity(intent);
    }
}
