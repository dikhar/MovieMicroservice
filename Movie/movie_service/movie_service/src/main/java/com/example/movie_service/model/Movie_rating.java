package com.example.movie_service.model;

import java.util.Arrays;

public class Movie_rating {
    private String movieID;
    private int id;

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie_rating(String movieID, int id) {
        this.movieID = movieID;
        this.id = id;
    }
}
