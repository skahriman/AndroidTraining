package com.example.sefakkahriman.dagger2demo.di;

import com.example.sefakkahriman.dagger2demo.api.UserApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MyModule {

    public static final String BASE_URL = "https://randomuser.me/";



    @Provides
    public Retrofit provideRetrofit(){

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return builder;


    }

    @Provides
    public UserApi provideUserAPI(Retrofit retrofit){

        UserApi userApi = retrofit.create(UserApi.class);
        return userApi;
    }
}
