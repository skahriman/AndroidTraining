package com.example.sefakkahriman.restcallproject.service;

import com.example.sefakkahriman.restcallproject.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

//    this is static
//    @GET("/users/skahriman/repos")
//    List<GitHubRepo> reposForUser(String user);

    //    this is dynameic
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);
}