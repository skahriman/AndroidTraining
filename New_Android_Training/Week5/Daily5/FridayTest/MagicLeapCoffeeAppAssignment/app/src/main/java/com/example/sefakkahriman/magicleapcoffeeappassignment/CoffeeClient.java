package com.example.sefakkahriman.magicleapcoffeeappassignment;


import com.example.sefakkahriman.magicleapcoffeeappassignment.model.CoffeeResponse;
import com.example.sefakkahriman.magicleapcoffeeappassignment.model.DetailCoffeeResponse;

import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Path;

public interface CoffeeClient {

    @GET("/coffees")
    Call<List<CoffeeResponse>> getCoffees();

    @GET("/coffees/{coffeeID}")
    Call<DetailCoffeeResponse> getDetailOfCoffee(@Path("coffeeID") String coffee);

}