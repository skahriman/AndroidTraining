package com.example.sefakkahriman.restcallproject.service;

import com.example.sefakkahriman.restcallproject.model.GitHubRepo;
import com.example.sefakkahriman.restcallproject.model.Owner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

//    this is static
//    @GET("/users/skahriman/repos")
//    List<GitHubRepo> reposForUser(String user);

//    this is dynamic
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

    @GET("/users/{user}")
    Call<List<Owner>> getGithubProfile(@Path("user") String user);

}
