package com.example.sefakkahriman.makingrestcalls.clients.retrofit;

import com.example.sefakkahriman.makingrestcalls.model.GithubProfile;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface RetrofitService {

    @GET("v2/5accc44a3200005e0077650a")
    Call<GithubProfile> getResponse();

    @GET("users/{user}")
    Call<GithubProfile> getResponseWithGithub(@Path("user") String username);

    @GET("users/{user}")
    Observable<GithubProfile> getResponseObs(@Path("user") String username);

}