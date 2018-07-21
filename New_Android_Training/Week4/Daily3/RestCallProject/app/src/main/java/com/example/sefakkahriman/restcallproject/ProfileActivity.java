package com.example.sefakkahriman.restcallproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sefakkahriman.restcallproject.adapter.OwnerAdapter;
import com.example.sefakkahriman.restcallproject.model.Owner;
import com.example.sefakkahriman.restcallproject.service.GitHubClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://api.github.com/";
    RecyclerView recyclerView;
    OwnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerView = findViewById(R.id.recycler_view_profile);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<List<Owner>> call = client.getOwner("skahriman");

        call.enqueue(new Callback<List<Owner>>() {
            @Override
            public void onResponse(Call<List<Owner>> call, Response<List<Owner>> response) {
                List<Owner> owners = response.body();

                adapter = new OwnerAdapter(owners);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Owner>> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
