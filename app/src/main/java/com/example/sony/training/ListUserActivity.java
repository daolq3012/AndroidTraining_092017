package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.sony.training.adapter.ListUserRecyclerViewAdapter;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.asynctask.GetListUserAsyncTask;
import com.example.sony.training.asynctask.InsertAsyncTask;
import com.example.sony.training.constant.Constant;
import com.example.sony.training.roomdb.database.Database;
import com.example.sony.training.roomdb.entity.User;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListUserActivity extends AppCompatActivity implements OnItemRecyclerViewClick{

    private Database mDatabase;
    private MainApplication mApplication;
    private GetListUserAsyncTask mGetListUserAsyncTask;
    private RecyclerView mRecyclerView;
    private ListUserRecyclerViewAdapter mListUserRecyclerViewAdapter;
    private List<User> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        initViews();
        initListeners();
    }

    private void initListeners() {
        mListUserRecyclerViewAdapter.setOnItemRecyclerViewClick(this);
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.listUserRecyclerView);
        mApplication = (MainApplication) getApplication();
        mDatabase = mApplication.getDatabase();
        mGetListUserAsyncTask = new GetListUserAsyncTask(this);
        mGetListUserAsyncTask.execute();
        mRecyclerView = findViewById(R.id.listUserRecyclerView);
        mListUserRecyclerViewAdapter = new ListUserRecyclerViewAdapter(getDataFromDB());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mListUserRecyclerViewAdapter);
    }
    private List<User> getDataFromDB(){
        try {
            mUsers = mGetListUserAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return mUsers ;
    }

    @Override
    public void OnItemClick(int id) {
        startActivity(new Intent(this, UserDetailActivity.class).putExtra(Constant.ID_USER, id));
    }
}
