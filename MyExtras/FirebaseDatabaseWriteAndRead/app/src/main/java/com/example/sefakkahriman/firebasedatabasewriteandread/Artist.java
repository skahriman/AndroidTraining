package com.example.sefakkahriman.firebasedatabasewriteandread;

import com.google.firebase.database.DatabaseReference;

public class Artist {

    String artistId;
    String artistName;
    String artistGenre;

    //This is to retrieve data from datase
    public Artist(){

    }

    public Artist(String artistId, String artistName, String artistGenre) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }
}
