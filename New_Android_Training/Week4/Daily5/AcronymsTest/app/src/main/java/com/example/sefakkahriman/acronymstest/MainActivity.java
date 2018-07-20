package com.example.sefakkahriman.acronymstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.sefakkahriman.acronymstest.adapter.MyAdapter;
import com.example.sefakkahriman.acronymstest.service.Client;

import java.util.List;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.sefakkahriman.acronymstest.data.Response;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://www.nactem.ac.uk/";
    RecyclerView recyclerView;
    MyAdapter adapter;

    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        Client client = retrofit.create(Client.class);
        Call<List<Response>> call = client.getResponse("sf");

        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                List<Response> responses = response.body();

                adapter = new MyAdapter(responses.get(0).getLfs());

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {

            }
        });


    }
}
