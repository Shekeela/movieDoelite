package com.example.moviedoelite.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviedoelite.R;
import com.example.moviedoelite.model.DetailedScreenMovieData;
import com.example.moviedoelite.model.MainScreenMovieData;
import com.example.moviedoelite.retrofit.RetrofitInstanceApiClient;
import com.example.moviedoelite.retrofit.RetrofitServiceInterface;
import com.example.moviedoelite.utils.Constants;
import com.example.moviedoelite.viewmodels.DetailedMovieListViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailedScreen extends AppCompatActivity {

    private DetailedScreenMovieData detailedData;
    ImageView mdetailedImageviewid;
    TextView mtitleid, myearid, mratedid, mreleasedid, mruntimeid, mgenreid, mdirectorid, mwriterid, mactorsid, mplotid, mlanguageid, mcountryid, mawardsid, mMetascoreid, imdbratingid, imdbvotesid, imdbid;
    TextView typeid, dvdid, boxofficeid, productionid, websiteid, ratingsSourceid, ratingsvalueid;
    Context context;
    private DetailedMovieListViewModel detailedMovieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailedscreen);

        mdetailedImageviewid = findViewById(R.id.detailedImageviewid);
        mtitleid = findViewById(R.id.titleid);
        myearid = findViewById(R.id.yearid);
        mratedid = findViewById(R.id.ratedid);
        mreleasedid = findViewById(R.id.releasedid);
        mruntimeid = findViewById(R.id.runtimeid);
        mgenreid = findViewById(R.id.genreid);
        mdirectorid = findViewById(R.id.directorid);
        mwriterid = findViewById(R.id.writerid);
        mactorsid = findViewById(R.id.actorsid);
        mplotid = findViewById(R.id.plotid);
        mcountryid = findViewById(R.id.countryid);
        mawardsid = findViewById(R.id.awardsid);
        mMetascoreid = findViewById(R.id.Metascoreid);
        imdbratingid = findViewById(R.id.imdbratingid);
        imdbvotesid = findViewById(R.id.imdbvotesid);
        imdbid = findViewById(R.id.imdbid);
        typeid = findViewById(R.id.typeid);
        dvdid = findViewById(R.id.dvdid);
        boxofficeid = findViewById(R.id.boxofficeid);
        productionid = findViewById(R.id.productionid);
        websiteid = findViewById(R.id.websiteid);
        ratingsSourceid = findViewById(R.id.ratingsSourceid);
        ratingsvalueid = findViewById(R.id.ratingsvalueid);
        mlanguageid = findViewById(R.id.languageid);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String id = bundle.getString("id");
        detailedMovieListViewModel = ViewModelProviders.of(this).get(DetailedMovieListViewModel.class);
        Log.d("sriram1", detailedMovieListViewModel.getId()+ "");
        detailedMovieListViewModel.setId(id);
        Log.d("sriram2", detailedMovieListViewModel.getId()+ "");
        Log.d("sriram3", ViewModelProviders.of(this).get(DetailedMovieListViewModel.class).getId()+ "");

        detailedMovieListViewModel.getMovieDeatils().observe(this, new Observer<DetailedScreenMovieData>() {
            @Override
            public void onChanged(DetailedScreenMovieData detailedScreenMovieData) {
                if (detailedScreenMovieData != null) {
                    Picasso.with(context).load(detailedScreenMovieData.getPoster()).into(mdetailedImageviewid);

                    mtitleid.setText("Title : " + detailedScreenMovieData.getTitle());

                }
            }
        });
    }
}

//        detailedMovieListViewModel.getMovieDeatils().observe(this, new Observer<ArrayList<DetailedMovieListViewModel>>() {
//            @Override
//            public void onChanged(ArrayList<DetailedMovieListViewModel> detailedMovieListViewModels) {
//                if(detailedMovieListViewModels!=null){
////                    adapter.setMovieList(searchResults);Picasso.with(context).load(movieResponse.getPoster()).into(mdetailedImageviewid);
//
//                    mtitleid.setText("Title : " +detailedMovieListViewModels.get());
//                    myearid.setText("Year : "+movieResponse.getYear());
//                    mratedid.setText("Rated : "+movieResponse.getRated());
//                    mreleasedid.setText("Released : "+movieResponse.getReleased());
//                    mruntimeid.setText(" Runtime : "+movieResponse.getRuntime());
//                    mgenreid.setText("Genre : "+movieResponse.getGenre());
//                    mdirectorid.setText("Director : "+movieResponse.getDirector());
//                    mwriterid.setText("Writer : "+movieResponse.getWriter());
//                    mactorsid.setText("Actors : "+movieResponse.getActors());
//                    mplotid.setText("Plot : "+movieResponse.getPlot());
//                    mlanguageid.setText("Language : " +movieResponse.getLanguage());
//                    mcountryid.setText("Country : "+movieResponse.getCountry());
//                    mawardsid.setText("Awards : "+movieResponse.getAwards());
//                    mMetascoreid.setText("MetaScore: "+movieResponse.getMetascore());
//                    imdbratingid.setText("IMDBRating : "+movieResponse.getImdbRating());
//                    imdbvotesid.setText("IMDBVotes : "+movieResponse.getImdbRating());
//                    imdbid.setText("IMDBid : "+movieResponse.getImdbID());
//                    typeid.setText("Type : "+movieResponse.getType());
//                    dvdid.setText("DVD : "+movieResponse.getdVD());
//                    boxofficeid.setText("BoxOffice : "+movieResponse.getBoxOffice());
//                    productionid.setText("Production : "+movieResponse.getProduction());
//                    websiteid.setText("Website : "+movieResponse.getWebsite());
//
//            }
//        });


