package com.example.moviedoelite.retrofit;

import com.example.moviedoelite.model.DetailedScreenMovieData;
import com.example.moviedoelite.model.MainScreenMovieData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitServiceInterface {


    @GET("?")
    Call<MainScreenMovieData> getMovieList(@Query("apikey")String app_id, @Query("s") String sname, @Query("type") String typemovie);

    @GET("?")
    Call<DetailedScreenMovieData> getDetailedList(@Query("apikey")String app_id,@Query("i") String movieId);
}
