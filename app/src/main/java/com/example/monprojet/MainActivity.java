package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button accesSW;
    Button accesBiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accesSW = findViewById(R.id.BoutonSW);
        accesSW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSW = new Intent(MainActivity.this, ActivityRechercheSW.class);
                startActivity(intentSW);
            }
        });

        accesBiere = findViewById(R.id.boutonBiere);
        accesBiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBiere = new Intent(MainActivity.this, ActivityRechercheBiere.class);
                startActivity(intentBiere);
            }
        });
    }
}
