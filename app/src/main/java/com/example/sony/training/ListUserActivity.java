package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sony.training.adapter.UserAdapter;
import com.example.sony.training.entity.UserEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class ListUserActivity extends AppCompatActivity implements OnItemClickListener {

    private UserDatabase mUserDatabase;
    private MainApplication mMainApplication;
    private SelectListUserFromDatabase mSelectListUserFromDatabase;
    private RecyclerView mRecyclerView;
    private UserAdapter mUserAdapter;
    private List<UserEntity> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        initViews();
        initEvents();


    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.listRecyclerView);
        mMainApplication = (MainApplication) getApplication();
        mUserDatabase = mMainApplication.getUserDatabase();
        mSelectListUserFromDatabase = new SelectListUserFromDatabase(this);
        mSelectListUserFromDatabase.execute();
        mRecyclerView = findViewById(R.id.listRecyclerView);
        mUserAdapter = new UserAdapter(getDataFromDatabase());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mUserAdapter);
    }

    private List<UserEntity> getDataFromDatabase() {
        try {
            mUsers = mSelectListUserFromDatabase.get();
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return mUsers;
    }

    private void initEvents() {
        mUserAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClicked(int id) {
        startActivity(new Intent(this, UserDetailActivity.class).putExtra(Constant.EXTRA_USER, id));
    }
}
