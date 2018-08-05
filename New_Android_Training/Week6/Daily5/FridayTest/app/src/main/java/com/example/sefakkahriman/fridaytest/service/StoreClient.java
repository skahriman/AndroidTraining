package com.example.sefakkahriman.fridaytest.service;

import com.example.sefakkahriman.fridaytest.model.ResponseStores;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StoreClient {

    @GET("store-locator")
    Call<ResponseStores> storesForUser(@Query("s") String zipcode);
}

