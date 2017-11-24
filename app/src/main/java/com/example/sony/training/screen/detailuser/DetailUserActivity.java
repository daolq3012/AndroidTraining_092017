package com.example.sony.training.screen.detailuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sony.training.Constant;
import com.example.sony.training.MainApplication;
import com.example.sony.training.R;
import com.example.sony.training.data.config.GithubApi;

public class DetailUserActivity extends AppCompatActivity implements DetailUserContract.View {

    private ImageView avatarImage;
    private TextView nameTextView;
    private DetailUserPresenter mDetailUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        initViews();
        mDetailUserPresenter = new DetailUserPresenter();
        mDetailUserPresenter.setView(this);
        GithubApi githubApi = MainApplication.getmGithubApi();
        mDetailUserPresenter.setGithubApi(githubApi);
        mDetailUserPresenter.getUserDetail();
    }

    private void initViews() {
        avatarImage = findViewById(R.id.avatarImage);
        nameTextView = findViewById(R.id.nameTextView);
    }

    @Override
    public String getUserName() {
        return getIntent().getStringExtra(Constant.EXTRA_USER);
    }

    @Override
    public void setUserName(String img, String name) {
        Glide.with(this).load(img).into(avatarImage);
        nameTextView.setText(name);
    }
}
