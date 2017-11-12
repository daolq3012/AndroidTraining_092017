package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

public class UserDetailActivity extends AppCompatActivity {
    private TextView mTxtUserNameDetail, mTxtGithubUrlDetail;
    private ImageView mImvAvatarDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        initViews();

        Item user = getIntent().getParcelableExtra(Constant.EXTRA_USER_DETAIL);
        mTxtUserNameDetail.setText(user.getLogin());
        mTxtGithubUrlDetail.setText(user.getHtmlUrl());
        Glide.with(this).load(user.getAvatarUrl()).into(mImvAvatarDetail);

    }

    private void initViews() {
        mImvAvatarDetail = (ImageView) findViewById(R.id.avatarDetailImageView);
        mTxtGithubUrlDetail = (TextView) findViewById(R.id.githubUrlDetailTextView);
        mTxtUserNameDetail = (TextView) findViewById(R.id.userNameDetailTextView);
    }
}
