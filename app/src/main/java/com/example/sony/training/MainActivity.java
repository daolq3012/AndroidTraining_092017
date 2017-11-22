package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.sony.training.service.config.GithubApi;
import com.example.sony.training.service.config.ServiceGenerators;
import com.example.sony.training.service.response.SearchGithubUserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubApi api = MainApplication.getGithubApi();

        api.seacrhGithubUser(12, "").enqueue(new Callback<SearchGithubUserResponse>() {
            @Override
            public void onResponse(Call<SearchGithubUserResponse> call,
                    Response<SearchGithubUserResponse> response) {
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<SearchGithubUserResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
            }
        });

    }
}
