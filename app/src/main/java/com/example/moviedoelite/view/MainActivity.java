package com.example.moviedoelite.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;

import com.example.moviedoelite.R;
import com.example.moviedoelite.model.DetailedScreenMovieData;
import com.example.moviedoelite.model.MainScreenMovieData;
import com.example.moviedoelite.model.SearchResult;
import com.example.moviedoelite.recyclerAdapter.RecyclerViewAdapter;
import com.example.moviedoelite.retrofit.RetrofitInstanceApiClient;
import com.example.moviedoelite.retrofit.RetrofitServiceInterface;
import com.example.moviedoelite.utils.Constants;
import com.example.moviedoelite.viewmodels.MovieListViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    RecyclerViewAdapter adapter;
    private ArrayList<SearchResult> searchlist;
    SearchView searchView;
    private String id;

    private MovieListViewModel mMovielistviewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context that = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchlist = new ArrayList<SearchResult>();
       mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(that, 2, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(that, searchlist);
        mRecyclerView.setAdapter(adapter);

        mMovielistviewmodel = ViewModelProviders.of(this).get(MovieListViewModel.class);

        mMovielistviewmodel.getMutableLiveData().observe(this, new Observer<ArrayList<SearchResult>>() {
           @Override
           public void onChanged(ArrayList<SearchResult> searchResults) {
               if(searchResults!=null){
                   adapter.setMovieList(searchResults);
               }
           }
       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        MenuItem item =  menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Sriram","Querying for"+query);
                mMovielistviewmodel.searchMovies(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
