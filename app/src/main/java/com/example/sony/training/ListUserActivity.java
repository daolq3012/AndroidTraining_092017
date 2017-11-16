package com.example.sony.training;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.DividerItemDecoration;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import com.example.sony.training.adapter.UserAdapter;
        import com.example.sony.training.database.entity.UserEntity;
        import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {

    private RecyclerView mUserRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        ArrayList<UserEntity> listItems =
                getIntent().getParcelableArrayListExtra(Constant.EXTRA_USER_LIST);

        mUserRecyclerView = (RecyclerView) findViewById(R.id.userRecyclerView);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                        false);
        mUserRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mUserRecyclerView.getContext(),
                        DividerItemDecoration.VERTICAL);
        mUserRecyclerView.addItemDecoration(dividerItemDecoration);

        UserAdapter adapter = new UserAdapter(listItems);
        adapter.setOnRecyclerViewItemClickListener(this);
        mUserRecyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(UserEntity user) {
        Intent intent = new Intent(this,UserDetailActivity.class);
        intent.putExtra(Constant.EXTRA_USER,user);
        startActivity(intent);
    }
}
