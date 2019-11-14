package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityRechercheBiere extends AppCompatActivity {

    String requeteBiere = "https://api.punkapi.com/v2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_biere);
    }
}
