package com.example.sefakkahriman.makingrestcalls.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    String BaseUrl;

    public RetrofitHelper(){
        BaseUrl = baseUrl;
    }

    public Retrofit create() {
        Retrofit retrofil = new Retrofit().Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory).create()
                .build();
        return retrofil;

    }


}
