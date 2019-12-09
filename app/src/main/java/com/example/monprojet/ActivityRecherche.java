package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;        // If connecting or reading goes wrong
import java.io.BufferedReader;     // For reading the response
import java.io.InputStreamReader;  // Also for reading

import java.net.URL;// Specifies a URL to a web server

import java.util.stream.Collectors;// Useful for collecting lines and converting them to a List
import java.util.ArrayList;
import java.util.List;

import org.json.*;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ActivityRecherche extends AppCompatActivity {
    //
    String requeteBiere = "https://api.punkapi.com/v2/";
    String requeteSW = "https://swapi.co/api/films/";
    String API = "";
    String QUERY = "beers?page=1&per_page=80&beer_name=";
    List<String> MonResultat = new ArrayList <String>();

    //
    Button buttonExeRequete;
    ListView ListeResultat;
    TextView nbResultat;
    TextInputEditText recherche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        API  = extras.getString ("Api");
        if (API.equals( "Biere"))
        {
            API = requeteBiere;
        }
        else
        {
            API = requeteSW;
        }
        setContentView(R.layout.activity_recherche);
        recherche = findViewById(R.id.recherche);
        nbResultat = findViewById(R.id.nb_Resultat);
        buttonExeRequete = findViewById(R.id.bouton_recherche);
        ListeResultat = findViewById(R.id.ListeResultats);

        buttonExeRequete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (API.equals(requeteBiere)) {
                        QUERY = "beers?page=1&per_page=80&beer_name=";
                        QUERY = QUERY + recherche.getText();
                        ListeResultat.setAdapter(null);
                        ListeResultat = (ListView) findViewById(R.id.ListeResultats);
                        buildRequete();
                        RemplirListe();
                    }
                    else
                    {
                        QUERY = "";
                        ListeResultat.setAdapter(null);
                        ListeResultat = (ListView) findViewById(R.id.ListeResultats);
                        buildRequete();
                        RemplirListe();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }
    protected void buildRequete() throws JSONException {

        Thread thread = new Thread(new Runnable(){

            public void run() {
        try {

            URL url = new URL(API + QUERY);
            StringBuilder response = new StringBuilder();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            for(Object line : reader.lines().collect(Collectors.toList())) {
                response.append(line);
            }
            if(API.equals(requeteBiere)) {
                for (Biere Biere : parse(response.toString())) {

                    MonResultat.add(Biere.name());
                    System.out.println("===================");
                    System.out.println(Biere);
                }
            }
            else
            {
                String test = parseFilm(response.toString());
                System.out.println(test);
            }
        } catch (IOException e) {
            System.err.println("Error fetching JSON: " + e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
            }

        });

        thread.start();
    }

    static List<Biere> parse(String json) throws JSONException {

        JSONArray jsonArray = new JSONArray(json);
        List<Biere> Biere = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String name = jsonObject.getString("name");
            String description = jsonObject.getString("description");
            double alcohol = jsonObject.getDouble("abv");
            JSONArray foodsJson = (JSONArray)jsonObject.get("food_pairing");
            ArrayList<String> foodStrings = new ArrayList<>();

            for(int j = 0; j < foodsJson.length(); j++) {
                foodStrings.add(foodsJson.getString(j));
            }

            Biere.add(new Biere(name,
                    description,
                    alcohol,
                    foodStrings)
            );

        }
        return Biere;
    }
    static String parseFilm(String json) throws JSONException {

        JSONArray jsonArray = new JSONArray(json);
        String description = "";
        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);

            description = jsonObject.getString("results");

        }
        return description;
    }

    void RemplirListe() throws JSONException {
        nbResultat.setText(MonResultat.size() + " résultas");
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_liste_resultat,R.id.textview, MonResultat);
        ListeResultat.setAdapter(adapter);

    }
}
