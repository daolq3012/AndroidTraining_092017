package com.example.sony.training;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.sony.training.model.User;
import com.example.sony.training.service.config.GithubApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private TextView mTxtUserName, mTxtUrl;
    private ImageView mIvAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTxtUserName = findViewById(R.id.userNameDetailTextView);
        mTxtUrl = findViewById(R.id.urlDetailTextView);
        mIvAvatar = findViewById(R.id.avatarImageView);

        String username = getIntent().getStringExtra(Constant.DETAIL_EXTRA);
        GithubApi api = MainApplication.getGithubApi();
        api.getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                String name = response.body().getLogin();
                String url = response.body().getUrl();
                String strImage = response.body().getAvatarUrl();
                mTxtUserName.setText(name);
                mTxtUrl.setText(url);
                Glide.with(DetailActivity.this).load(strImage).into(mIvAvatar);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
