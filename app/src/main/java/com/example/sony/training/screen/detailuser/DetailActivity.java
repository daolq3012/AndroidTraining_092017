package com.example.sony.training.screen.detailuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.sony.training.application.MainApplication;
import com.example.sony.training.R;
import com.example.sony.training.constant.Constant;
import com.example.sony.training.model.User;
import com.example.sony.training.data.service.config.GithubApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements DetailUserContract.View {
    private TextView mTxtUserName, mTxtUrl;
    private ImageView mIvAvatar;
    private DetailUserPresenter mPresenter;
    private GithubApi mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();

        mApi = MainApplication.getGithubApi();

        mPresenter = new DetailUserPresenter();
        mPresenter.setView(this);
        mPresenter.setApi(mApi);

        mPresenter.getDataFromInternet();


    }

    private void initViews() {
        mTxtUserName = findViewById(R.id.userNameDetailTextView);
        mTxtUrl = findViewById(R.id.urlDetailTextView);
        mIvAvatar = findViewById(R.id.avatarImageView);
    }

    @Override
    public String getUsername() {
        return getIntent().getStringExtra(Constant.DETAIL_EXTRA);
    }

    @Override
    public void setUsernameTextView(String name) {
        mTxtUrl.setText(name);
    }

    @Override
    public void setUrlTextView(String url) {
        mTxtUrl.setText(url);
    }

    @Override
    public void setImage(String strImage) {
        Glide.with(DetailActivity.this).load(strImage).into(mIvAvatar);
    }
}
