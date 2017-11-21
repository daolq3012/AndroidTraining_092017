package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.sony.training.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AppCompatActivity {

    private ImageView mImgAvatar;
    private TextView mTxtUsername, mTxtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        initViews();

        final String username = getIntent().getStringExtra(Constant.EXTRA_USERNAME);
        MainApplication.getGitHubApi().getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Glide.with(getApplicationContext()).load(response.body().getAvatarUrl()).into(mImgAvatar);
                mTxtUsername.setText(response.body().getLogin());
                mTxtUrl.setText(response.body().getHtmlUrl());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void initViews() {
        mImgAvatar = findViewById(R.id.imgAvatarDetails);
        mTxtUsername = findViewById(R.id.txtUsernameDetails);
        mTxtUrl = findViewById(R.id.txtUrlDetals);
    }
}
