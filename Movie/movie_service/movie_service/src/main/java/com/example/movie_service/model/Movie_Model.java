package com.example.movie_service.model;

import java.util.PrimitiveIterator;

public class Movie_Model {
    private String name;

    public String getName() {
        return name;
    }

    public Movie_Model(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private String desc;
    private int rating ;

}
