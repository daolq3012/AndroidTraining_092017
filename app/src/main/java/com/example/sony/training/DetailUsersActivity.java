package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUsersActivity extends AppCompatActivity {
    private TextView mIdView,mNameView,urlView;
    private ImageView mAvatarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_users);

        mIdView = findViewById(R.id.viewId);
        mNameView = findViewById(R.id.viewName);
        urlView = findViewById(R.id.viewUrl);
        mAvatarView = findViewById(R.id.avatarView);

        String username = getIntent().getStringExtra(Constant.EXTRA_DETAIL_USER);
        GitHubApi api = MainApplication.getGithubApi();
        api.getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                String id = response.body().getId().toString();
                String name = response.body().getLogin();
                String url = response.body().getUrl();
                String strImage = response.body().getAvatarUrl();

                mIdView.setText(id);
                mNameView.setText(name);
                urlView.setText(url);
                Glide.with(DetailUsersActivity.this).load(strImage).into(mAvatarView);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
