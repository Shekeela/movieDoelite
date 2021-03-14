package com.example.moviedoelite.model;

import android.media.Rating;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailedScreenMovieData {
    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Year")
    @Expose
    private String year;

    @SerializedName("Rated")
    @Expose
    private String rated;

    @SerializedName("Released")
    @Expose
    private String released;

    @SerializedName("Runtime")
    @Expose
    private String runtime;

    @SerializedName("Genre")
    @Expose
    private String genre;

    @SerializedName("Director")
    @Expose
    private String director;

    @SerializedName("Writer")
    @Expose
    private String writer;

    @SerializedName("Actors")
    @Expose
    private String actors;

    @SerializedName("Plot")
    @Expose
    private String plot;

    @SerializedName("Language")
    @Expose
    private String language;

    @SerializedName("Country")
    @Expose
    private String country;

    @SerializedName("Awards")
    @Expose
    private String awards;

    @SerializedName("Poster")
    @Expose
    private String poster;

    @SerializedName("Ratings")
    @Expose
    private ArrayList<Rating> ratings = new ArrayList<Rating>();

    @SerializedName("Metascore")
    @Expose
    private String metascore;

    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;

    @SerializedName("imdbVotes")
    @Expose
    private String imdbVotes;

    @SerializedName("imdbID")
    @Expose
    private String imdbID;

    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("DVD")
    @Expose
    private String dVD;

    @SerializedName("BoxOffice")
    @Expose
    private String boxOffice;

    @SerializedName("Production")
    @Expose
    private String production;

    @SerializedName("Website")
    @Expose
    private String website;

    @SerializedName("Response")
    @Expose
    private String response;

    public DetailedScreenMovieData(String title, String year, String rated, String released,
                                   String runtime, String genre, String director, String writer, String actors, String plot,
                                   String language, String country, String awards, String poster, ArrayList<Rating> ratings,
                                   String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String dVD,
                                   String boxOffice, String production, String website, String response) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.ratings = ratings;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.type = type;
        this.dVD = dVD;
        this.boxOffice = boxOffice;
        this.production = production;
        this.website = website;
        this.response = response;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getdVD() {
        return dVD;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public String getWebsite() {
        return website;
    }

    public String getResponse() {
        return response;
    }
}
