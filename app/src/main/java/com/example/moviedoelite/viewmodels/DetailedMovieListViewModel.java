package com.example.moviedoelite.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviedoelite.model.DetailedScreenMovieData;
import com.example.moviedoelite.model.SearchResult;
import com.example.moviedoelite.repository.DetailedMovieRepo;
import com.example.moviedoelite.repository.MovieRepo;

import java.util.ArrayList;

public class DetailedMovieListViewModel extends ViewModel {

    private DetailedMovieRepo detailedMovieRepo;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private MutableLiveData<DetailedScreenMovieData> mutableLiveData;


    public DetailedMovieListViewModel(){
        detailedMovieRepo = new DetailedMovieRepo();
    }

    public LiveData<DetailedScreenMovieData> getMovieDeatils() {
        if(mutableLiveData==null){
            mutableLiveData = detailedMovieRepo.requestMovieDetails(id);
        }
        return mutableLiveData;
    }


}
