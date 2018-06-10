package com.example.sefakkahriman.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sefakkahriman.dagger2demo.api.UserApi;
import com.example.sefakkahriman.dagger2demo.di.DaggerMyComponent;
import com.example.sefakkahriman.dagger2demo.di.MyComponent;
import com.example.sefakkahriman.dagger2demo.model.Response;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyTag" ;

    @Inject
    UserApi userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyComponent myComponent = DaggerMyComponent.create();
        myComponent.inject(this);

        Call<Response> call =   userApi.getResults();
        call.enqueue(new Callback<Response>() {


            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                Log.d(TAG, "onFailure: "  + t.getMessage());
            }
        });
    }
}
