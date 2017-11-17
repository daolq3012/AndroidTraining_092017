package com.example.sony.training.services.config;

import com.example.sony.training.services.response.SearchGitHubUsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by daolq on 11/17/17.
 */

public interface GitHubApi {

    @GET("/search/users")
    Call<SearchGitHubUsersResponse> searchUserGithub(@Query("per_page") int limit, @Query("q") String keyword);
}
