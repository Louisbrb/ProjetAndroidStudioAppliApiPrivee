package com.example.monprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityListeResultat extends AppCompatActivity {

    ArrayAdapter<List> monAdapteur;
    Button boutonDetail;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_resultat);
        boutonDetail = findViewById(R.id.button);
        textview    =findViewById(R.id.textview);

        boutonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDetail(textview.getText().toString());
            }
        });
    }
    protected void OpenDetail(String ElementARechercher)
    {
        Intent intentRecherche = new Intent(ActivityListeResultat.this, MainActivity.class);
        intentRecherche.putExtra ("search",ElementARechercher );
        startActivity(intentRecherche);
    }
}
