package com.example.sony.training.service.config;

import com.example.sony.training.model.User;
import com.example.sony.training.service.response.SearchGithubUserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 11/17/17.
 */

public interface GithubApi {
    //tu ket noi det github search va tu dong tao object. tra ve object
    @GET("/search/users")
    Call<SearchGithubUserResponse> seacrhGithubUser(@Query("per_page") int limit, @Query("q") String keyword);

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
