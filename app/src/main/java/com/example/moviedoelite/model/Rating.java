package com.example.moviedoelite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("Source")
    @Expose
    private String source;

    @SerializedName("Value")
    @Expose
    private String value;

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }
}
