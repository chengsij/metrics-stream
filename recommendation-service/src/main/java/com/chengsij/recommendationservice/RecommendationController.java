package com.chengsij.recommendationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/movie/recommendations", method = RequestMethod.GET)
    @ResponseBody
    public Movie[] movieRecommendations(){
        Movie[] result = restTemplate.getForObject("http://movie-service/movies", Movie[].class);
        return result;
    }


    @RequestMapping(value="/user/recommendations", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> userRecommendations(){
        return ResponseEntity.ok(MovieDB.movieList);
    }


}
