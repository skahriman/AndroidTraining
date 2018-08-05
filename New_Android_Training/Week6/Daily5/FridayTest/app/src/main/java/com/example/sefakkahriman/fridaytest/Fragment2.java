package com.example.sefakkahriman.fridaytest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sefakkahriman.fridaytest.adapter.StoreAdapter;
import com.example.sefakkahriman.fridaytest.model.ResponseStores;
import com.example.sefakkahriman.fridaytest.model.Store;
import com.example.sefakkahriman.fridaytest.service.StoreClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    public static final String STRING_TAG = Fragment2.class.getSimpleName();

    private static final String BASE_URL = "https://order.dominos.com/power/";
    private RecyclerView recyclerView;
    private StoreAdapter adapter;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    public void getList(String zipCode){
        

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StoreClient client = retrofit.create(StoreClient.class);

        client.storesForUser(zipCode.trim()).enqueue(new Callback<ResponseStores>() {
            @Override
            public void onResponse(Call<ResponseStores> call, Response<ResponseStores> response) {
                List<Store> stores = response.body().getStores();

                adapter = new StoreAdapter(getContext(), stores);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Call<ResponseStores> call, Throwable t) {

                Toast.makeText(getContext(), ":(", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
