package com.example.sefakkahriman.acronymstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sefakkahriman.acronymstest.service.Client;

import java.util.List;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.sefakkahriman.acronymstest.adapter.Response;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://www.nactem.ac.uk/";

    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        Client client = retrofit.create(Client.class);
        Call<List<Response>> call = client.getResponse("sf");

        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                Log.d(TAG, "onResponse: "  + response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
