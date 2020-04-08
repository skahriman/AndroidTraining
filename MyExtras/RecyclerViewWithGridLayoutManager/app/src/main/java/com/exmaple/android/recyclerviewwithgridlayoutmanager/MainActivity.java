package com.exmaple.android.recyclerviewwithgridlayoutmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;
    int[] icons = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_recyclerView);
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, icons);
        mRecyclerView.setAdapter(adapter);
    }
}
