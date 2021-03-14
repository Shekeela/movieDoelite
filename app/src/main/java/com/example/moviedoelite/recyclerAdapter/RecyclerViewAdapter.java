package com.example.moviedoelite.recyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedoelite.view.DetailedScreen;
import com.example.moviedoelite.R;
import com.example.moviedoelite.model.SearchResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {



    Context context;
    ArrayList<SearchResult> mainData;

    LayoutInflater inflater;  // 1.a

    public RecyclerViewAdapter(Context context, ArrayList<SearchResult> data) { // 3

        this.mainData = data;
        this.context = context;

        inflater= LayoutInflater.from(context);  //1.a
    }

    public void setMovieList(ArrayList<SearchResult> movieLsit){
        this.mainData=movieLsit;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("viewholder","oncreateViewholder entered");
        View view = inflater.inflate(R.layout.recycleritem,parent,false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {



        Picasso.with(context).load(mainData.get(position).getPoster()).into(holder.recyclerViewitemMOvieImage);





        holder.recyclerViewitemMOvieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(context, DetailedScreen.class);
                go.putExtra("id",mainData.get(position).getImdbID());

           context.startActivity(go);

            }
        });
    }

    @Override
    public int getItemCount() {

        return mainData.size();
    }

}

