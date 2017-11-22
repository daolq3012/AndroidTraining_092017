package com.example.sony.training.screen.userdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.sony.training.Constant;
import com.example.sony.training.MainApplication;
import com.example.sony.training.R;
import com.example.sony.training.data.service.config.GitHubApi;

public class UserDetailsActivity extends AppCompatActivity implements UserDetailContract.View {

    private UserDetailContract.Presenter mPresenter;
    private ImageView mImgAvatar;
    private TextView mTxtUsername, mTxtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        initViews();
        mPresenter = new UserDetailPresenter();
        mPresenter.setView(this);
        GitHubApi gitHubApi = MainApplication.getGitHubApi();
        mPresenter.setGithubApi(gitHubApi);
        mPresenter.getUserDetail();

    }

    private void initViews() {
        mImgAvatar = findViewById(R.id.imgAvatarDetails);
        mTxtUsername = findViewById(R.id.txtUsernameDetails);
        mTxtUrl = findViewById(R.id.txtUrlDetals);
    }

    @Override
    public String getUsername() {
        return getIntent().getStringExtra(Constant.EXTRA_USERNAME);
    }

    @Override
    public void updateUserDetail(String avatarUrl, String login, String htmlUrl) {
        Glide.with(this).load(avatarUrl).into(mImgAvatar);
        mTxtUsername.setText(login);
        mTxtUrl.setText(htmlUrl);
    }
}
