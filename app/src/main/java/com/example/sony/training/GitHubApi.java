package com.example.sony.training;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by phong on 11/18/17.
 */

public interface GitHubApi {
    @GET("/search/users")
    Call<SearchGitHubUsersResponse> seacrhGithubUser(@Query("per_page") int limit, @Query("q") String keyword);

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
