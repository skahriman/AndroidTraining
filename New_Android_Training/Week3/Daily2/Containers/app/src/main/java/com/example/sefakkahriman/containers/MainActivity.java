package com.example.sefakkahriman.containers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sefakkahriman.containers.adapter.LVBookAdapter;
import com.example.sefakkahriman.containers.adapter.RVBookAdapter;
import com.example.sefakkahriman.containers.model.DataCreator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateSimpleListView();

        populateBookListView();

        RecyclerView rvBooks = findViewById(R.id.rvBooks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RVBookAdapter adapter = new RVBookAdapter(DataCreator.getBookList());
        rvBooks.setLayoutManager(layoutManager);
        rvBooks.setAdapter(adapter);
    }

    private void populateBookListView() {
        ListView lvBooks = findViewById(R.id.lvBooks);
        LVBookAdapter adapter =
                new LVBookAdapter(this, R.layout.book_list_layout, DataCreator.getBookList());
        lvBooks.setAdapter(adapter);
    }

    private void populateSimpleListView() {
        ListView lvSimple = findViewById(R.id.lvSimple);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, DataCreator.getSimpleStrings());
        lvSimple.setAdapter(arrayAdapter);
    }
}
