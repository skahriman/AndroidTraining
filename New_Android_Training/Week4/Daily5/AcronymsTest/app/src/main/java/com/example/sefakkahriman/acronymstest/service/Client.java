package com.example.sefakkahriman.acronymstest.service;

import com.example.sefakkahriman.acronymstest.adapter.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Client {

    @GET("software/acromine/dictionary.py")
    Call<List<Response>> getResponse(@Query("sf") String name);

}
