package com.example.moviedoelite.repository;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviedoelite.model.DetailedScreenMovieData;
import com.example.moviedoelite.model.SearchResult;
import com.example.moviedoelite.retrofit.RetrofitInstanceApiClient;
import com.example.moviedoelite.retrofit.RetrofitServiceInterface;
import com.example.moviedoelite.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailedMovieRepo  {


    private final String TAG = getClass().getSimpleName();

    Context context;

    public MutableLiveData<DetailedScreenMovieData> requestMovieDetails(String id) {

        final MutableLiveData<DetailedScreenMovieData> mutableLiveData = new MutableLiveData<>();



    RetrofitServiceInterface service = RetrofitInstanceApiClient.getClient().create(RetrofitServiceInterface.class);

    Call<DetailedScreenMovieData> call = service.getDetailedList(Constants.API_KEY,id);
    call.enqueue(new Callback<DetailedScreenMovieData>() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onResponse(@NonNull Call<DetailedScreenMovieData> call, @NonNull Response<DetailedScreenMovieData> response) {

            if (response.code() == 200) {
                DetailedScreenMovieData movieResponse = response.body();
                assert movieResponse != null;
                mutableLiveData.setValue(movieResponse);

            }
        }

        @Override
        public void onFailure (Call < DetailedScreenMovieData > call, Throwable t){
            Log.d("failure", t.getMessage());
        }

    });
return mutableLiveData;
}
}
