package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityRechercheSW extends AppCompatActivity {

    String requeteSW = "https://swapi.co/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
    }
}
