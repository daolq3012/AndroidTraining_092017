package com.example.sony.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by phong on 11/21/17.
 */

public class ListMemberActivity extends AppCompatActivity implements OnItemRecyclerViewClick {

    private static final String TAG = "ListMemberActivity";
    private AppDatabase mDatabase;
    private MainApplication mApplication;
    private GetListMemberAsyncTask mGetListMemberAsyncTask;
    private RecyclerView mRecyclerView;
    private MemberAdapter mMemberAdapter;
    private List<Member> mMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        initViews();
        initListeners();
    }

    private void initListeners() {
        mMemberAdapter.setOnItemRecyclerViewClick(this);
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mApplication = (MainApplication) getApplication();
        mDatabase = mApplication.getDatabase();
        mGetListMemberAsyncTask = new GetListMemberAsyncTask(this);
        mGetListMemberAsyncTask.execute();
        mRecyclerView = findViewById(R.id.recycler_view);
        mMemberAdapter = new MemberAdapter(getDataFromDB());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mMemberAdapter);
    }

    private List<Member> getDataFromDB() {
        try {
            mMembers = mGetListMemberAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return mMembers;
    }

    @Override
    public void OnItemClick(int id) {
        startActivity(new Intent(this, MemberDetailActivity.class).putExtra(Constant.ID_MEMBER, id));
    }
}