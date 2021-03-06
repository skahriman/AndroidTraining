package com.example.sefakkahriman.retforitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sefakkahriman.retforitdemo.api.model.GitHubRepo;
import com.example.sefakkahriman.retforitdemo.api.service.GitHubClient;
import com.example.sefakkahriman.retforitdemo.ui.adapter.GitHubRepoAdapter;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.pagination_list);


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

                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

}