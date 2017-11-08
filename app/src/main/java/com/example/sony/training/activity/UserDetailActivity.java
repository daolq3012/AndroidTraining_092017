package com.example.sony.training.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.sony.training.Constant;
import com.example.sony.training.R;
import com.example.sony.training.model.User;

public class UserDetailActivity extends Activity {

    private TextView mUserNameTextView, mGitHubUrlTextView;
    private ImageView mAvatarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        mUserNameTextView = (TextView) findViewById(R.id.userNameTextView);
        mGitHubUrlTextView = (TextView) findViewById(R.id.githubUrlTextView);
        mAvatarImageView = (ImageView) findViewById(R.id.avatarImageView);

        User user = getIntent().getParcelableExtra(Constant.EXTRA_USER);

        mUserNameTextView.setText(user.getLogin());
        mGitHubUrlTextView.setText(user.getHtmlUrl());
        Glide.with(this).load(user.getAvatarUrl()).into(mAvatarImageView);
    }
}
