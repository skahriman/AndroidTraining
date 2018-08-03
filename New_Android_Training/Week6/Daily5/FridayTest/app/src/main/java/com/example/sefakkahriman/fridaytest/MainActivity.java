package com.example.sefakkahriman.fridaytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sefakkahriman.fridaytest.adapter.StoreAdapter;
import com.example.sefakkahriman.fridaytest.model.Store;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener {

    private List<Store> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StoreAdapter adapter;

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private EditText etMain;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMain = findViewById(R.id.etMain);
        btnSearch = findViewById(R.id.btnSearch);
        addFragments();
    }

    private void addFragments() {
        Fragment1 fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder1, fragment1, Fragment1.STRING_TAG)
                .addToBackStack(Fragment1.STRING_TAG)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
