package com.example.sefakkahriman.magicleapcoffeeappassignment;


import com.example.sefakkahriman.magicleapcoffeeappassignment.model.CoffeeResponse;

import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Path;

public interface CoffeeClient {
//  "https://api.github.com/"
//    @GET("/users/{user}/repos")

    @GET("/coffees")
    Call<List<CoffeeResponse>> getCoffees();

    @GET("/coffees/{coffeeID}")
    Call<List<CoffeeResponse>> getDetailOfCoffee(@Path("coffeeID") String user);
}