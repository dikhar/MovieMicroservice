package com.example.movie_rating.controller;

import com.example.movie_rating.rating.Movie_Rating;
import com.example.movie_rating.rating.User_Rating;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/ratingsdata")
public class Movie_Ratingcntrl{
    @RequestMapping("/{id}")
    public Movie_Rating getRating(@PathVariable("id") String id)
    {
        log.info("Movie rating id");
        return new Movie_Rating(id,4);
    }
    @RequestMapping("/user/{id}")
    public User_Rating getRate(@PathVariable("id") String id)
    {
        log.info("movierating 1");
        List<Movie_Rating> movieRatings= Arrays.asList(
                new Movie_Rating("Hi",3),
                new Movie_Rating("Hi2",4)
        );
        User_Rating userRating=new User_Rating();

        userRating.setUser(movieRatings);
        log.info("returning the movie rating");
        return userRating;
    }
}
