package com.example.moviedoelite.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainScreenMovieData extends ViewModel {

    @SerializedName("Search")
    @Expose
    private ArrayList<SearchResult> Search = new ArrayList<SearchResult>();

    public ArrayList<SearchResult> getSearch() {
        return Search;
    }
}
