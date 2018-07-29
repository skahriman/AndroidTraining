package com.example.sefakkahriman.magicleapcoffeeappassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.magicleapcoffeeappassignment.model.DetailCoffeeResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://demo6983184.mockable.io/";

    TextView getLastUpdatedAt;
    ImageView getUrl;
    TextView getName;
    TextView getId;
    TextView getDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_detail);

        getLastUpdatedAt = findViewById(R.id.getLastUpdatedAt);
        getUrl = findViewById(R.id.detail_image);
        getName = findViewById(R.id.getName);
        getId = findViewById(R.id.getId);
        getDesc = findViewById(R.id.getDesc);

        
        Bundle extras = getIntent().getExtras();
        String id = (String) extras.get("ID");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CoffeeClient client = retrofit.create(CoffeeClient.class);

        Call<DetailCoffeeResponse> call = client.getDetailOfCoffee(id);
        
        call.enqueue(new Callback<DetailCoffeeResponse>() {
            @Override
            public void onResponse(Call<DetailCoffeeResponse> call, Response<DetailCoffeeResponse> response) {

                DetailCoffeeResponse responses = response.body();

                if (!responses.getImageUrl().trim().equals(""))
                    Picasso.get().load(responses.getImageUrl()).into(getUrl);

                getLastUpdatedAt.setText(responses.getLastUpdatedAt());
                getName.setText(responses.getName());
                getId.setText(responses.getId());
                getDesc.setText(responses.getDesc());

            }

            @Override
            public void onFailure(Call<DetailCoffeeResponse> call, Throwable t) {
                Toast.makeText(DetailActivity.this, ":(", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}
