package com.example.movie_rating.rating;


import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Movie_Rating {
    private String movieName;
    private int id;

    public String getMovieName() {
        return movieName;
    }

    public Movie_Rating(String movieName, int id) {
        log.info("into the movie rating class ");
        this.movieName = movieName;
        this.id = id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
