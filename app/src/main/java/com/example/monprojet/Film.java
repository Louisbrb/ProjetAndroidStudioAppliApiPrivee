package com.example.monprojet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oleur on 21/12/2014.
 * Film model represents a Star Wars single film.
 */
public class Film implements Serializable {
    public String title;

    public int episodeId;

    public String openingCrawl;

    public String director;
    public String producer;
    public String url;
    public String created;
    public String edited;

    public ArrayList<String> speciesUrls;

    public ArrayList<String> starshipsUrls;

    public ArrayList<String> vehiclesUrls;

    public ArrayList<String> planetsUrls;

    public ArrayList<String> charactersUrls;
}