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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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