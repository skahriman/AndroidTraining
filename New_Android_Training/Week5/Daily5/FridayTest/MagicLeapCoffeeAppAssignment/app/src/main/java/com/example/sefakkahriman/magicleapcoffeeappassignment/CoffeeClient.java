package com.example.sefakkahriman.magicleapcoffeeappassignment;


import com.example.sefakkahriman.magicleapcoffeeappassignment.model.CoffeeResponse;

import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Path;

public interface CoffeeClient {
//  "https://api.github.com/"
//    @GET("/users/{user}/repos")

    @GET("/coffees/{coffee}")
    Call<List<CoffeeResponse>> reposForUser(@Path("coffee") String user);
}