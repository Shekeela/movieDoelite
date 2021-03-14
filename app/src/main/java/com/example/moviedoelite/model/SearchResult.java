package com.example.moviedoelite.model;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("Title")
    @Expose
    private String Title;

    @SerializedName("Year")
    @Expose
    private String Year;

    @SerializedName("imdbID")
    @Expose
    private String imdbID;

    @SerializedName("Poster")
    @Expose
    private String Poster;

    public SearchResult(String title, String year, String imdbID, String poster) {
        Title = title;
        Year = year;
        this.imdbID = imdbID;
        Poster = poster;
    }

    public String getPoster() {
        return Poster;
    }

    public String getImdbID() {
        return imdbID;
    }
    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }
}
