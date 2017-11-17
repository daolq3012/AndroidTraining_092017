package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.sony.training.services.config.GitHubApi;
import com.example.sony.training.services.config.ServiceGenerators;
import com.example.sony.training.services.response.SearchGitHubUsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubApi api = ServiceGenerators.createApiService(this);

        api.searchUserGithub(12,"abc").enqueue(new Callback<SearchGitHubUsersResponse>() {
            @Override
            public void onResponse(Call<SearchGitHubUsersResponse> call,
                    Response<SearchGitHubUsersResponse> response) {
                Log.d(TAG, "onResponse: "+response.body().getItems().size());
            }

            @Override
            public void onFailure(Call<SearchGitHubUsersResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }
}
