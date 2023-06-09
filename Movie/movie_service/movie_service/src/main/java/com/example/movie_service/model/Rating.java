package com.example.movie_service.model;

public class Rating {
    private String movie;
    private int id;

    public Rating(String movie, int id) {
        this.movie = movie;
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
