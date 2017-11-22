package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sony.training.model.User;
import com.example.sony.training.services.config.GitHubApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDeltailsActivity extends AppCompatActivity {
    private TextView nameTextView;
    private ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_deltails);

        initView();

        String name = getIntent().getStringExtra(Constant.EXTRA_USER);
        GitHubApi api = MainApplication.getmGithubApi();
        api.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                    String name = response.body().getLogin();
                    String img = response.body().getAvatarUrl();
                    nameTextView.setText(name);

                Glide.with(UserDeltailsActivity.this).load(img).into(avatarImage);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void initView() {
        nameTextView = findViewById(R.id.nameTextView);
        avatarImage = findViewById(R.id.avatarImage);
    }
}
