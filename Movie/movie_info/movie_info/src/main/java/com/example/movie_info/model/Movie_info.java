package com.example.movie_info.model;

public class Movie_info {
    private String movieID;

    public Movie_info(String movieID, String name) {
        this.movieID = movieID;
        this.name = name;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
