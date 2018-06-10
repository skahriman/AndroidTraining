package com.example.sefakkahriman.dagger2demo.api;

import com.example.sefakkahriman.dagger2demo.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    //https://randomuser.me/api/
    @GET("/api")
    Call<Response> getResults();
}
