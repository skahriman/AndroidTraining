package com.example.sefakkahriman.chasemobileappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sefakkahriman.chasemobileappdemo.adapter.MyAdapter;
import com.example.sefakkahriman.chasemobileappdemo.adapter.RecyclerViewAdapterForTransactions;
import com.example.sefakkahriman.chasemobileappdemo.adapter_model.ListItem;
import com.example.sefakkahriman.chasemobileappdemo.adapter_model.ListItemForTransaction;

import java.util.ArrayList;
import java.util.List;

public class AccountDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItemForTransaction> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        setMyAdapter();
    }

    public void setMyAdapter() {
        recyclerView = findViewById(R.id.recyclerViewIDForTransactionDetails);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        ListItemForTransaction item1 = new ListItemForTransaction("Walmart", "10", "01/02/2018", "1000");
        ListItemForTransaction item2 = new ListItemForTransaction("Windixy", "30", "05/02/2018", "500");
        listItems.add(item1);
        listItems.add(item2);

        adapter = new RecyclerViewAdapterForTransactions(this, listItems);
        recyclerView.setAdapter(adapter);
    }
}
