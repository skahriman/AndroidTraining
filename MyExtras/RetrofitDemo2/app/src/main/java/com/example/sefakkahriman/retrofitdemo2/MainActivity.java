package com.example.sefakkahriman.retrofitdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<GithubRepoResponse> repoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GithubRepoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubClient client = retrofit.create(GithubClient.class);
        Call<List<GithubRepoResponse>> call = client.reposForUser("skahriman");

        call.enqueue(new Callback<List<GithubRepoResponse>>() {
            @Override
            public void onResponse(Call<List<GithubRepoResponse>> call, Response<List<GithubRepoResponse>> response) {
                List<GithubRepoResponse> repos = response.body();

                adapter = new GithubRepoAdapter(getApplicationContext(), repos);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<GithubRepoResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ":(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new GithubRepoAdapter(this, repoList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
