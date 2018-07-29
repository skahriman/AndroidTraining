package com.example.sefakkahriman.magicleapcoffeeappassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sefakkahriman.magicleapcoffeeappassignment.adapter.CoffeeAdapter;
import com.example.sefakkahriman.magicleapcoffeeappassignment.model.CoffeeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://demo6983184.mockable.io/";

    private RecyclerView recyclerView;
    private CoffeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CoffeeClient client = retrofit.create(CoffeeClient.class);
        Call<List<CoffeeResponse>> call = client.getCoffees();

        call.enqueue(new Callback<List<CoffeeResponse>>() {
            @Override
            public void onResponse(Call<List<CoffeeResponse>> call, Response<List<CoffeeResponse>> response) {
                List<CoffeeResponse> responses = response.body();

                adapter = new CoffeeAdapter(MainActivity.this, responses);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<CoffeeResponse>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "error:(", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
