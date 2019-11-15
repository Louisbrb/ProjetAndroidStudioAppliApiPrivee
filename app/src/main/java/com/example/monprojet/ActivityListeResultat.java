package com.example.monprojet;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ActivityListeResultat extends AppCompatActivity {

    ArrayAdapter<List> monAdapteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_resultat);

        /*monAdapteur = new ArrayAdapter<List>(MainActivity.this,
                android.R.layout.future_liste_item,
                );*/
    }
}
