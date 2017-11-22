package com.example.sony.training.data.service.config;

import com.example.sony.training.model.User;
import com.example.sony.training.data.service.response.SearchGithubUserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Admin on 11/17/17.
 */

public interface GitHubApi {
    @GET("/search/users")
    Call<SearchGithubUserResponse> searchUserGithub(@Query("per_page") int limit,@Query("q") String keyword);

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
