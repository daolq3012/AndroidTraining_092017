package com.example.sony.training.screen.listuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.sony.training.Constant;
import com.example.sony.training.MainApplication;
import com.example.sony.training.OnRecyclerViewItemListener;
import com.example.sony.training.R;
import com.example.sony.training.screen.userdetail.UserDetailsActivity;
import com.example.sony.training.screen.listuser.adapter.GithubUserAdapter;
import com.example.sony.training.model.User;
import com.example.sony.training.data.service.config.GitHubApi;
import java.util.List;

public class ListUserActivity extends AppCompatActivity implements OnRecyclerViewItemListener,ListUserContract.View {

    private RecyclerView mRecyclerViewUser;
    private GithubUserAdapter mGithubUserAdapter;
    private ListUserContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        mRecyclerViewUser = findViewById(R.id.recyclerViewUser);

        mPresenter = new ListUserPresenter();
        mPresenter.setView(this);
        GitHubApi gitHubApi = MainApplication.getGitHubApi();
        mPresenter.setGitHubApi(gitHubApi);
        mPresenter.getListGithubUser();

        mGithubUserAdapter = new GithubUserAdapter(this);
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

    @Override
    public void retrieveData(List<User> listItems) {
        mGithubUserAdapter.updateData(listItems);
    }

    @Override
    public String getKeyword() {
        return getIntent().getStringExtra(Constant.EXTRA_KEYWORD);
    }

    @Override
    public int getLimit() {
        return getIntent().getIntExtra(Constant.EXTRA_LIMIT,0);
    }
}
