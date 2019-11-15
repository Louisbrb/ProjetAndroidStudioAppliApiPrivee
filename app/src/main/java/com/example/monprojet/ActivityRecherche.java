package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityRecherche extends AppCompatActivity {
    //
    String requeteBiere = "https://api.punkapi.com/v2/";
    String requeteSW = "https://swapi.co/api/";
    String API = "";
    //
    Button buttonExeRequete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent (). getExtras ();
        String API  = extras.getString ("Api");
        setContentView(R.layout.activity_recherche);
        buttonExeRequete = findViewById(R.id.bouton_recherche);
        buttonExeRequete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildRequete();
            }
        });

    }
    protected void buildRequete()
    {

    }
}
