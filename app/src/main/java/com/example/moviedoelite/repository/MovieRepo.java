package com.example.moviedoelite.repository;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.example.moviedoelite.model.MainScreenMovieData;
import com.example.moviedoelite.model.SearchResult;
import com.example.moviedoelite.recyclerAdapter.RecyclerViewAdapter;
import com.example.moviedoelite.retrofit.RetrofitInstanceApiClient;
import com.example.moviedoelite.retrofit.RetrofitServiceInterface;
import com.example.moviedoelite.utils.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {

    private final String TAG = getClass().getSimpleName();


    public void requestMovies(String movieName, MutableLiveData<ArrayList<SearchResult>> mutableLiveData) {

        RetrofitServiceInterface service = RetrofitInstanceApiClient.getClient().create(RetrofitServiceInterface.class);

        Call<MainScreenMovieData> call = service.getMovieList(Constants.API_KEY,movieName,"movie");

        final MutableLiveData<ArrayList<SearchResult>> liveData = mutableLiveData;

        call.enqueue(new Callback<MainScreenMovieData>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(@NonNull Call<MainScreenMovieData> call, @NonNull Response<MainScreenMovieData> response) {

                if (response.code() == 200) {
                    assert response.body() != null;
                    liveData.postValue(response.body().getSearch());

                }
            }

            @Override
            public void onFailure(Call<MainScreenMovieData> call, Throwable t) {
                Log.d("movieresponse",t.getMessage());

            }
        });
    }
}
