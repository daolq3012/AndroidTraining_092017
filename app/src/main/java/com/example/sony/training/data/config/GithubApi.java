package com.example.sony.training.data.config;

import com.example.sony.training.model.User;
import com.example.sony.training.data.response.SearchGitHubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ThanhThang on 22/11/2017.
 */

public interface GithubApi {
    @GET("/search/users")
    Call<SearchGitHubUsersResponse> searchUserGitHub(@Query("per_pagae") int limit, @Query("q") String keyword);

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
