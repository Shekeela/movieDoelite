package com.example.moviedoelite.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviedoelite.model.MainScreenMovieData;
import com.example.moviedoelite.model.SearchResult;
import com.example.moviedoelite.repository.MovieRepo;


import java.util.ArrayList;

public class MovieListViewModel extends ViewModel {

    private MovieRepo movieRepo;
    private MutableLiveData<ArrayList<SearchResult>> mutableLiveData;

    public MutableLiveData<ArrayList<SearchResult>> getMutableLiveData() {
        return mutableLiveData;
    }



    public MovieListViewModel(){
        movieRepo = new MovieRepo();
        mutableLiveData = new MutableLiveData<>();

    }

    public void searchMovies(String movieName) {
        movieRepo.requestMovies(movieName, mutableLiveData);
    }


}
