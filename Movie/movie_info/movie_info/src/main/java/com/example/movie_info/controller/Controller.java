package com.example.movie_info.controller;

import com.example.movie_info.model.Movie_info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class Controller {
    @RequestMapping("/{id}")
    public Movie_info getMovie(@PathVariable ("id") String id)
    {
        return new Movie_info(id,"test");
    }

    @RequestMapping("/rating/{ratingID}")
    public List<Movie_info> getRating(@PathVariable("ratingID") String ratingID){
            List<Movie_info> ratings=Arrays.asList(
                    new Movie_info("1234","Hello"),
                    new Movie_info("5678","Hello1")
            );
            return ratings;
    }
}

