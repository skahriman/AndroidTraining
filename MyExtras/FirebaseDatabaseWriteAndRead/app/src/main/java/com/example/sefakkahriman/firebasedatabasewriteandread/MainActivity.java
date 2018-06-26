package com.example.sefakkahriman.firebasedatabasewriteandread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonAdd;
    Spinner spinnerGenres;

    DatabaseReference databaseReference;
    ListView listViewArtists;
    List<Artist> artistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        buttonAdd = findViewById(R.id.buttonAddArtist);
        spinnerGenres = findViewById(R.id.spinnerGenre);

        listViewArtists = findViewById(R.id.listViewArtists);
        artistList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("artists");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clear artist list
                artistList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Artist artist = ds.getValue(Artist.class);

                    artistList.add(artist);
                }
                ArtistListAdapter adapter = new ArtistListAdapter(MainActivity.this, artistList);
                listViewArtists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addArtist(){
        String name = editTextName.getText().toString();
        String genre = spinnerGenres.getSelectedItem().toString();

        if (!TextUtils.isEmpty(name)) {
            //creteates unique string
            String id = databaseReference.push().getKey();

            Artist artist = new Artist(id, name, genre);

            databaseReference.child(id).setValue(artist);

            Toast.makeText(this, "artist added.", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Enter name!", Toast.LENGTH_SHORT).show();

        }
    }

}
