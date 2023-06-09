package com.example.movie_service.controller;

import com.example.movie_service.model.Movie_Model;
import com.example.movie_service.model.Movie_rating;
import com.example.movie_service.model.Rating;
import com.example.movie_service.model.User_Rating;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/movie")
@Slf4j
public class Movie_Controller {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/{id}")

    public List<Movie_Model> getRate(@PathVariable ("id") String id) {
        log.info("calling movie rating");
        User_Rating rating=restTemplate.getForObject("http://localhost:8083/"
                    ,User_Rating.class);

        return rating.getUser().stream().map(Rating -> {
                    log.info("calling movie info");
                    Movie_Model movie_model = restTemplate.getForObject("http://localhost:8080/"+Rating.getId(),
                            Movie_Model.class);
                    return new Movie_Model(movie_model.getName(), "action", Rating.getId());
                })
                .collect(Collectors.toList());
    }
}
