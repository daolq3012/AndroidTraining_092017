package com.example.sony.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class UserDetailActivity extends AppCompatActivity {

    private TextView mTxtUserName;
    private TextView mTxtUrl;
    private ImageView mImgAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        initViews();


        Item user = getIntent().getParcelableExtra(Constrants.EXTRA_USER);

        mTxtUserName.setText(user.getLogin());
        mTxtUrl.setText(user.getHtmlUrl());
        mTxtUrl.setText(user.getHtmlUrl());
        Glide.with(this).load(user.getAvatarUrl()).into(mImgAvatar);
    }

    private void initViews() {
        mTxtUserName = (TextView) findViewById(R.id.userNameTextView);
        mTxtUrl = (TextView) findViewById(R.id.githubUrlTextView);
        mImgAvatar = (ImageView) findViewById(R.id.avatarImageView);
    }
}
