package com.example.sefakkahriman.restcallproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sefakkahriman.restcallproject.adapter.RVAdapterForProfile;
import com.example.sefakkahriman.restcallproject.model.GitHubRepo;
import com.example.sefakkahriman.restcallproject.service.GitHubClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RVAdapterForProfile adapter;
    List<GitHubRepo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        recyclerView = findViewById(R.id.recycler_view);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<List<GitHubRepo>> call = client.reposForUser("skahriman");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {

                List<GitHubRepo> repos = response.body();

                adapter = new RVAdapterForProfile(repos);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
    }

    public void onButtonClick(View view) {

        switch (view.getId()) {

            case R.id.btnProfile:
                startActivity(new Intent(getApplicationContext(), GithubProfileActivity.class));
                break;

            case R.id.btnRepo:
                startActivity(new Intent(getApplicationContext(), RepositoryActivity.class));
                break;
        }
    }

}