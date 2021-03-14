package com.example.moviedoelite.recyclerAdapter;


import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedoelite.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView recyclerViewitemMOvieImage;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        recyclerViewitemMOvieImage = itemView.findViewById(R.id.recyclerViewitemMOvieImage);
    }
}
